package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyOwnerServiceImpl implements PropertyOwnerService{

    private final PropertyOwnerRepository propertyOwnerRepository;

    @Override
    public PropertyOwner createPropertyOwner(PropertyOwner propertyOwner) {
        return propertyOwnerRepository.save(propertyOwner);
    }

    @Override
    public PropertyOwner findPropertyOwnerByVatNumber(String vatNumber) {
        return propertyOwnerRepository.findByVatNumber(vatNumber);
    }

    @Override
    public PropertyOwner findPropertyOwnerByEmail(String email) {
        return propertyOwnerRepository.findByEmail(email);
    }

    @Override
    public boolean updatePropertyOwnerByVatNumber(Long id, PropertyOwner propertyOwner) {
        Optional<PropertyOwner> tempPropertyOwner = propertyOwnerRepository.findById(id);

        if (tempPropertyOwner.isPresent()) {
            PropertyOwner existingOwner = tempPropertyOwner.get();

            existingOwner.setVatNumber(propertyOwner.getVatNumber());
            existingOwner.setName(propertyOwner.getName());
            existingOwner.setSurname(propertyOwner.getSurname());
            existingOwner.setEmail(propertyOwner.getEmail());
            existingOwner.setAddress(propertyOwner.getAddress());
            existingOwner.setPhoneNumber(propertyOwner.getPhoneNumber());
            existingOwner.setUsername(propertyOwner.getUsername());
            existingOwner.setPropertyList(propertyOwner.getPropertyList());

            propertyOwnerRepository.save(existingOwner);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePropertyOwnerByVatNumber(Long id) {
        if (propertyOwnerRepository.existsById(id)) {
            propertyOwnerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PropertyOwner> findAllPropertyOwners() {
        return propertyOwnerRepository.findAll();
    }

    @Override
    public PropertyOwner findPropertyOwnerById(Long id) {
        Optional<PropertyOwner> tempPropertyOwner = propertyOwnerRepository.findById(id);

        if (tempPropertyOwner.isPresent()) {
            PropertyOwner existingPropertyOwner = tempPropertyOwner.get();
            return existingPropertyOwner;
        }
        return null;
    }
}
