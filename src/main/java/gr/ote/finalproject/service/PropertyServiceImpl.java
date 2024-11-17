package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.createProperty(property);
    }

    @Override
    public Property findPropertyByPropertyIdNumber(String propertyIdNumber) {
        return propertyRepository.findPropertyByPropertyIdNumber(propertyIdNumber);
    }

    @Override
    public List<Property> findPropertiesByOwnerVat(String vatNumber) {
        return propertyRepository.findPropertiesByOwnerVat(vatNumber);
    }

    @Override
    public boolean updatePropertyByPropertyIdNumber(String propertyIdNumber, Property property) {
        return propertyRepository.updatePropertyByPropertyIdNumber(propertyIdNumber, property);
    }

    @Override
    public boolean deletePropertyByPropertyIdNumber(String propertyIdNumber) {
        return propertyRepository.deletePropertyByPropertyIdNumber(propertyIdNumber);
    }

    @Override
    public List<Property> findAllProperties() {
        return propertyRepository.findAllProperties();
    }
}

