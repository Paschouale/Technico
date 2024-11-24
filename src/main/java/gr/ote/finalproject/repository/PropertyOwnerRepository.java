package gr.ote.finalproject.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import gr.ote.finalproject.domain.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {

    PropertyOwner findByVatNumber(String vatNumber);
    PropertyOwner findByEmail(String email);

}
