package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);
    Property findPropertyByPropertyIdNumber(String propertyIdNumber);
    List<Property> findPropertiesByOwnerVat(String vatNumber);
    boolean updatePropertyByPropertyIdNumber(String propertyIdNumber, Property property);
    boolean deletePropertyByPropertyIdNumber(String propertyIdNumber);
    List<Property> findAllProperties();
}

