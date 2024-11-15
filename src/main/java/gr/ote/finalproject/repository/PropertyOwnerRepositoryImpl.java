package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.PropertyOwner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyOwnerRepositoryImpl implements PropertyOwnerRepository{

    private List<PropertyOwner> propertyOwnerList;

    @Override
    public PropertyOwner createPropertyOwner(PropertyOwner propertyOwner) {
        propertyOwnerList.add(propertyOwner);
        return propertyOwner;
    }

    @Override
    public PropertyOwner findPropertyOwnerByVatNumber(String vatNumber) {
        for (PropertyOwner po : propertyOwnerList){
            if (po.getVatNumber().equals(vatNumber)){
                return po;
            }
        }
        return  null;
    }

    @Override
    public PropertyOwner findPropertyOwnerByEmail(String email) {
        for (PropertyOwner po : propertyOwnerList){
            if (po.getEmail().equals(email)){
                return po;
            }
        }
        return  null;
    }

    @Override
    public boolean updatePropertyOwnerByVatNumber(String vatNumber, PropertyOwner propertyOwner) {
        PropertyOwner propertyOwnerFromList = findPropertyOwnerByVatNumber(vatNumber);
        if (propertyOwnerFromList == null) return false;
        propertyOwnerFromList.setVatNumber(propertyOwner.getVatNumber());
        propertyOwnerFromList.setName(propertyOwner.getName());
        propertyOwnerFromList.setSurname(propertyOwner.getSurname());
        propertyOwnerFromList.setAddress(propertyOwner.getAddress());
        propertyOwnerFromList.setPhoneNumber(propertyOwner.getPhoneNumber());
        propertyOwnerFromList.setEmail(propertyOwner.getEmail());
        propertyOwnerFromList.setUsername(propertyOwner.getUsername());
        propertyOwnerFromList.setPropertyList(propertyOwner.getPropertyList());
        return true;
    }

    @Override
    public boolean updatePropertyOwnerByEmail(String email, PropertyOwner propertyOwner) {
        PropertyOwner propertyOwnerFromList = findPropertyOwnerByEmail(email);
        if (propertyOwnerFromList == null) return false;
        propertyOwnerFromList.setVatNumber(propertyOwner.getVatNumber());
        propertyOwnerFromList.setName(propertyOwner.getName());
        propertyOwnerFromList.setSurname(propertyOwner.getSurname());
        propertyOwnerFromList.setAddress(propertyOwner.getAddress());
        propertyOwnerFromList.setPhoneNumber(propertyOwner.getPhoneNumber());
        propertyOwnerFromList.setEmail(propertyOwner.getEmail());
        propertyOwnerFromList.setUsername(propertyOwner.getUsername());
        propertyOwnerFromList.setPropertyList(propertyOwner.getPropertyList());
        return true;
    }

    @Override
    public boolean deletePropertyOwnerByVatNumber(String vatNumber) {
        PropertyOwner propertyOwner = findPropertyOwnerByVatNumber(vatNumber);
        if (propertyOwner == null) return false;
        propertyOwnerList.remove(propertyOwner);
        return true;
    }

    @Override
    public boolean deletePropertyOwnerByEmail(String email) {
        PropertyOwner propertyOwner = findPropertyOwnerByEmail(email);
        if (propertyOwner == null) return false;
        propertyOwnerList.remove(propertyOwner);
        return true;
    }
}
