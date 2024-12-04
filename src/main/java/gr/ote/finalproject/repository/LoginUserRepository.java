package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    Optional<LoginUser> findByUsernameAndPassword(String username, String password);
}