package gr.ote.finalproject.domain;

import gr.ote.finalproject.enumeration.PropertyType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Property extends BaseDomain{

    private String propertyIdNumber;
    private String address;
    private Integer yearOfConstruction;
    private PropertyType propertyType;
    private PropertyOwner propertyOwner; //Για το vat
    private List<Repair> repairList;
}
