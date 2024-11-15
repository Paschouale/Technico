package gr.ote.finalproject.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PropertyOwner extends BaseDomain{

    private String vatNumber;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private String username;
//    private String password;
    private List<Property> propertyList;
}
