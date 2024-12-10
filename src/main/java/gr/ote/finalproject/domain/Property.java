package gr.ote.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import gr.ote.finalproject.enumeration.PropertyType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "properties")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_seq", initialValue = 1, allocationSize = 1)
public class Property extends BaseDomain{

    private String numberE9;
    private String address;
    private Integer yearOfConstruction;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @ManyToOne
    @JsonIgnoreProperties("propertyList")
    private PropertyOwner propertyOwner; //Για το vat

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("property")
    private List<Repair> repairList;

    public Property(Long id, List<Repair> repairList, PropertyOwner propertyOwner, PropertyType propertyType, Integer yearOfConstruction, String address, String propertyIdNumber) {
        super(id);
        this.repairList = repairList;
        this.propertyOwner = propertyOwner;
        this.propertyType = propertyType;
        this.yearOfConstruction = yearOfConstruction;
        this.address = address;
    }
}
