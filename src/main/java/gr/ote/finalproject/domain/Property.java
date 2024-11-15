package gr.ote.finalproject.domain;

import gr.ote.finalproject.enumeration.PropertyType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Property extends BaseDomain{

    private String propertyIdNumber;
    private String address;
    private Integer yearOfConstruction;
    private PropertyType propertyType;
    private PropertyOwner propertyOwner; //Για το vat
    private List<Repair> repairList;

    public Property(Long id, List<Repair> repairList, PropertyOwner propertyOwner, PropertyType propertyType, Integer yearOfConstruction, String address, String propertyIdNumber) {
        super(id);
        this.repairList = repairList;
        this.propertyOwner = propertyOwner;
        this.propertyType = propertyType;
        this.yearOfConstruction = yearOfConstruction;
        this.address = address;
        this.propertyIdNumber = propertyIdNumber;
    }
}
