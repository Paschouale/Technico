package gr.ote.finalproject.domain;

import gr.ote.finalproject.enumeration.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "login_users")
@SequenceGenerator(name = "idGenerator", sequenceName = "login_seq", initialValue = 1, allocationSize = 1)
public class LoginUser extends BaseDomain{

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "property_owner_id", referencedColumnName = "id")
    private PropertyOwner propertyOwner;
}
