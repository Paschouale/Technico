package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
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

//    @Override
//    public List<Property> findPropertiesByOwnerVat(String vatNumber) {
//        return propertyRepository.findPropertiesByOwnerVat(vatNumber);
//    }

    @Override
    public boolean updatePropertyByPropertyIdNumber(Long propertyIdNumber, Property property) {
        Optional<Property> tempProperty = propertyRepository.findById(propertyIdNumber);

        if (tempProperty.isPresent()) {
            Property existingProperty = tempProperty.get();

            existingProperty.setAddress(property.getAddress());
            existingProperty.setYearOfConstruction(property.getYearOfConstruction());
            existingProperty.setPropertyType(property.getPropertyType());
            existingProperty.setPropertyOwner(property.getPropertyOwner());
            existingProperty.setRepairList(property.getRepairList());

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
}

