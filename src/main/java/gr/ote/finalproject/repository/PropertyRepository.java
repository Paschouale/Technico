package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.Property;

import java.util.List;

public interface PropertyRepository {
    Property createProperty(Property property);
    Property findPropertyByPropertyIdNumber(String propertyIdNumber);
    List<Property> findPropertiesByOwnerVat(String vatNumber);
    boolean updatePropertyByPropertyIdNumber(String propertyIdNumber, Property property);
    boolean deletePropertyByPropertyIdNumber(String propertyIdNumber);
    List<Property> findAllProperties();
}
