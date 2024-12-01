package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.PropertyOwner;

import java.util.List;

public interface PropertyOwnerService {
    PropertyOwner createPropertyOwner(PropertyOwner propertyOwner);
    PropertyOwner findPropertyOwnerByVatNumber(String vatNumber);
    PropertyOwner findPropertyOwnerByEmail(String email);
    boolean updatePropertyOwnerById(Long id, PropertyOwner propertyOwner);
    boolean deletePropertyOwnerById(Long id);
    List<PropertyOwner> findAllPropertyOwners();
    PropertyOwner findPropertyOwnerById(Long id);
}
