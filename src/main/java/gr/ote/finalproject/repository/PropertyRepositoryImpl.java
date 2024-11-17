package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.enumeration.PropertyType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyRepositoryImpl implements PropertyRepository {

    private static List<Property> propertyList = new ArrayList<>();

    static {
        PropertyOwner owner1 = new PropertyOwner(1L, "132156888", "Dim", "Pas", "Gryp", "698", "test@test.gr", "paschouale", null);
        propertyList.add(new Property(1L, null, owner1, PropertyType.APARTMENT, 2005, "Stadiou 10", "P001"));
        propertyList.add(new Property(2L, null, owner1, PropertyType.DETACHED_HOUSE, 1990, "Nireos 234", "P002"));
    }

    @Override
    public Property createProperty(Property property) {
        propertyList.add(property);
        return property;
    }

    @Override
    public Property findPropertyByPropertyIdNumber(String propertyIdNumber) {
        return propertyList.stream()
                .filter(p -> p.getPropertyIdNumber().equals(propertyIdNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Property> findPropertiesByOwnerVat(String vatNumber) {
        List<Property> ownerProperties = new ArrayList<>();
        for (Property property : propertyList) {
            if (property.getPropertyOwner() != null && property.getPropertyOwner().getVatNumber().equals(vatNumber)) {
                ownerProperties.add(property);
            }
        }
        return ownerProperties;
    }

    @Override
    public boolean updatePropertyByPropertyIdNumber(String propertyIdNumber, Property property) {
        Property existingProperty = findPropertyByPropertyIdNumber(propertyIdNumber);
        if (existingProperty == null) return false;

        existingProperty.setPropertyIdNumber(property.getPropertyIdNumber());
        existingProperty.setAddress(property.getAddress());
        existingProperty.setYearOfConstruction(property.getYearOfConstruction());
        existingProperty.setPropertyType(property.getPropertyType());
        existingProperty.setPropertyOwner(property.getPropertyOwner());
        existingProperty.setRepairList(property.getRepairList());
        return true;
    }

    @Override
    public boolean deletePropertyByPropertyIdNumber(String propertyIdNumber) {
        Property property = findPropertyByPropertyIdNumber(propertyIdNumber);
        if (property == null) return false;
        propertyList.remove(property);
        return true;
    }

    @Override
    public List<Property> findAllProperties() {
        return propertyList;
    }
}
