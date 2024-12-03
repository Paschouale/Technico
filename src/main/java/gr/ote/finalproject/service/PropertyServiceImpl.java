package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.exception.NumberE9Exception;
import gr.ote.finalproject.exception.ResourceNotFoundException;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import gr.ote.finalproject.repository.PropertyRepository;
import gr.ote.finalproject.repository.RepairRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final RepairRepository repairRepository;

    @Override
    public Property createProperty(Property property) {
        validateUniqueNumberE9(property.getNumberE9());
        return propertyRepository.save(property);
    }

    @Override
    public Property findPropertyByPropertyIdNumber(Long propertyIdNumber) {
        Optional<Property> tempProperty = propertyRepository.findById(propertyIdNumber);

        if (tempProperty.isPresent()) {
            Property existingProperty = tempProperty.get();
            return existingProperty;
        }
        return null;
    }

    @Override
    public List<Property> findAllByPropertyOwnerVat(String vatNumber) {
        return propertyRepository.findAllByPropertyOwnerVatNumber(vatNumber);
    }

    @Override
    public boolean updatePropertyByPropertyIdNumber(Long propertyIdNumber, Property property) {
        Optional<Property> tempProperty = propertyRepository.findById(propertyIdNumber);

        if (tempProperty.isPresent()) {
            validateUniqueNumberE9ForUpdate(property.getNumberE9(), propertyIdNumber);

            Property existingProperty = tempProperty.get();

            // Δημιουργία ή Ενημέρωση της λίστας repairs
            if (property.getRepairList() != null) {
                for (Repair repair : property.getRepairList()) {
                    if (repair.getId() == null) {
                        throw new IllegalArgumentException("Repair ID must not be null.");
                    }

                    Repair existingRepair = repairRepository.findById(repair.getId())
                            .orElseThrow(() -> new ResourceNotFoundException("Repair not found with ID: " + repair.getId()));

                    // Ενημέρωση του Property στο Repair
                    existingRepair.setProperty(existingProperty);
                    repairRepository.save(existingRepair);
                }
            }

            // Ενημέρωση άλλων πεδίων
            existingProperty.setNumberE9(property.getNumberE9());
            existingProperty.setAddress(property.getAddress());
            existingProperty.setYearOfConstruction(property.getYearOfConstruction());
            existingProperty.setPropertyType(property.getPropertyType());
            existingProperty.setPropertyOwner(property.getPropertyOwner());

            propertyRepository.save(existingProperty);
            return true;
        }
        return false;
    }


    @Override
    public boolean deletePropertyByPropertyIdNumber(Long propertyIdNumber) {
        if (propertyRepository.existsById(propertyIdNumber)) {
            propertyRepository.deleteById(propertyIdNumber);
            return true;
        }
        return false;
    }

    @Override
    public List<Property> findAllProperties() {
        return propertyRepository.findAll();
    }

    private void validateUniqueNumberE9(String numberE9) {
        if (propertyRepository.existsByNumberE9(numberE9)) {
            throw new NumberE9Exception("Number E9 already in use: " + numberE9);
        }
    }

    private void validateUniqueNumberE9ForUpdate(String numberE9, Long id) {
        Property property = propertyRepository.findByNumberE9(numberE9);
        if (property != null && !property.getId().equals(id)) {
            throw new NumberE9Exception("Number E9 already in use by another property: " + numberE9);
        }
    }
}

