package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;

import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);
    Property findPropertyByPropertyIdNumber(Long propertyIdNumber);
    List<Property> findAllByPropertyOwnerVat(String vatNumber);
    boolean updatePropertyByPropertyIdNumber(Long propertyIdNumber, Property property);
    boolean deletePropertyByPropertyIdNumber(Long propertyIdNumber);
    List<Property> findAllProperties();
}

