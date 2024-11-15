package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.PropertyOwner;

import java.util.List;

public interface PropertyOwnerService {
    PropertyOwner createPropertyOwner(PropertyOwner propertyOwner);
    PropertyOwner findPropertyOwnerByVatNumber(String vatNumber);
    PropertyOwner findPropertyOwnerByEmail(String email);
    boolean updatePropertyOwnerByVatNumber(String vatNumber, PropertyOwner propertyOwner);
    boolean deletePropertyOwnerByVatNumber(String vatNumber);
    List<PropertyOwner> findAllPropertyOwners();
}
