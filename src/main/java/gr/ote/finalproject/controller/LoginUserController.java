package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.LoginUser;
import gr.ote.finalproject.service.LoginUserService;
import gr.ote.finalproject.transfer.LoginRequest;
import gr.ote.finalproject.transfer.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginUserController {

    private final LoginUserService loginUserService;


    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginUser loginUser = loginUserService.login(loginRequest.getUsername(), loginRequest.getPassword());

        LoginResponse response = new LoginResponse(
                loginUser.getId(),
                loginUser.getUsername(),
                loginUser.getRole(),
                loginUser.getPropertyOwner() != null ? loginUser.getPropertyOwner().getId() : null
        );

        return ResponseEntity.ok(response);
    }
}