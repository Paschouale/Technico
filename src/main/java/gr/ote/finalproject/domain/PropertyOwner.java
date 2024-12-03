package gr.ote.finalproject.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "property_owners")
@SequenceGenerator(name = "idGenerator", sequenceName = "propertyOwner_seq", initialValue = 1, allocationSize = 1)
public class PropertyOwner extends BaseDomain{

    private String vatNumber;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private String username;
//    private String password;
    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> propertyList;

    public PropertyOwner(Long id, String vatNumber, String name, String surname, String address, String phoneNumber, String email, String username, List<Property> propertyList) {
        super(id);
        this.vatNumber = vatNumber;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.propertyList = propertyList;
    }
}
