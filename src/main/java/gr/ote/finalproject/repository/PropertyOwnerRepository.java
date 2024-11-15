package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.PropertyOwner;

import java.util.List;

public interface PropertyOwnerRepository {
    PropertyOwner createPropertyOwner(PropertyOwner propertyOwner);
    PropertyOwner findPropertyOwnerByVatNumber(String vatNumber);
    PropertyOwner findPropertyOwnerByEmail(String email);
    boolean updatePropertyOwnerByVatNumber(String vatNumber, PropertyOwner propertyOwner);
    boolean deletePropertyOwnerByVatNumber(String vatNumber);
    List<PropertyOwner> findAllPropertyOwner();
}
