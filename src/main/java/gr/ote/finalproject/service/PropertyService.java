package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;

import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);
    Property findPropertyByPropertyIdNumber(Long propertyIdNumber);
//    List<Property> findPropertiesByOwnerVat(String vatNumber);
    boolean updatePropertyByPropertyIdNumber(Long propertyIdNumber, Property property);
    boolean deletePropertyByPropertyIdNumber(Long propertyIdNumber);
    List<Property> findAllProperties();
}

