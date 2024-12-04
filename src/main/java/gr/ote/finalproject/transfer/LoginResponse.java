package gr.ote.finalproject.transfer;

import gr.ote.finalproject.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private Long id;
    private String username;
    private Role role;
    private Long propertyOwnerId;
}