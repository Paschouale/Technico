package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.PropertyOwner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyOwnerRepositoryImpl implements PropertyOwnerRepository{

    private static List<PropertyOwner> propertyOwnerList = new ArrayList<>();

    static {
        propertyOwnerList.add(new PropertyOwner(1L,"132156888", "Dim","Pas","Gryp",
                "698","test@test.gr", "paschouale", null));
        propertyOwnerList.add(PropertyOwner.builder().id(2L).vatNumber("123").name("Jim").surname("Pas").
               address("Gryp").phoneNumber("698").email("t@t.gr").username("tot").propertyList(null).build());
    }

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
    public boolean deletePropertyOwnerByVatNumber(String vatNumber) {
        PropertyOwner propertyOwner = findPropertyOwnerByVatNumber(vatNumber);
        if (propertyOwner == null) return false;
        propertyOwnerList.remove(propertyOwner);
        return true;
    }

    @Override
    public List<PropertyOwner> findAllPropertyOwner() {
        return propertyOwnerList;
    }
}
