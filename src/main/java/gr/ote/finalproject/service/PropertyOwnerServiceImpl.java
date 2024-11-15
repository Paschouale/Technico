package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyOwnerServiceImpl implements PropertyOwnerService{

    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;

    @Override
    public PropertyOwner createPropertyOwner(PropertyOwner propertyOwner) {
        return propertyOwnerRepository.createPropertyOwner(propertyOwner);
    }

    @Override
    public PropertyOwner findPropertyOwnerByVatNumber(String vatNumber) {
        return propertyOwnerRepository.findPropertyOwnerByVatNumber(vatNumber);
    }

    @Override
    public PropertyOwner findPropertyOwnerByEmail(String email) {
        return propertyOwnerRepository.findPropertyOwnerByEmail(email);
    }

    @Override
    public boolean updatePropertyOwnerByVatNumber(String vatNumber, PropertyOwner propertyOwner) {
        return propertyOwnerRepository.updatePropertyOwnerByVatNumber(vatNumber, propertyOwner);
    }

    @Override
    public boolean updatePropertyOwnerByEmail(String email, PropertyOwner propertyOwner) {
        return propertyOwnerRepository.updatePropertyOwnerByEmail(email, propertyOwner);
    }

    @Override
    public boolean deletePropertyOwnerByVatNumber(String vatNumber) {
        return propertyOwnerRepository.deletePropertyOwnerByVatNumber(vatNumber);
    }

    @Override
    public boolean deletePropertyOwnerByEmail(String email) {
        return propertyOwnerRepository.deletePropertyOwnerByEmail(email);
    }
}
