package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.LoginUser;
import gr.ote.finalproject.enumeration.Role;
import gr.ote.finalproject.repository.LoginUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserServiceImpl implements LoginUserService{

    private final LoginUserRepository loginUserRepository;

    @Override
    public LoginUser login(String username, String password) {
        LoginUser loginUser = loginUserRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));

        if (loginUser.getRole() == Role.PROPERTY_OWNER && loginUser.getPropertyOwner() == null) {
            throw new IllegalStateException("No PropertyOwner associated with this user.");
        }

        return loginUser;
    }
}
