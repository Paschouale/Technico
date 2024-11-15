package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.PropertyOwner;

public interface PropertyOwnerRepository {
    PropertyOwner createPropertyOwner(PropertyOwner propertyOwner);
    PropertyOwner findPropertyOwnerByVatNumber(String vatNumber);
    PropertyOwner findPropertyOwnerByEmail(String email);
    boolean updatePropertyOwnerByVatNumber(String vatNumber, PropertyOwner propertyOwner);
    boolean updatePropertyOwnerByEmail(String email, PropertyOwner propertyOwner);
    boolean deletePropertyOwnerByVatNumber(String vatNumber);
    boolean deletePropertyOwnerByEmail(String email);
}
