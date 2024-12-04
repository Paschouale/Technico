package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.LoginUser;

public interface LoginUserService {

    public LoginUser login(String username, String password);
}
