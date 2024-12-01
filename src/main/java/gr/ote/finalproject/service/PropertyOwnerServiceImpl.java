package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.exception.EmailException;
import gr.ote.finalproject.exception.PhoneNumberException;
import gr.ote.finalproject.exception.VatNumberException;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyOwnerServiceImpl implements PropertyOwnerService{

    private final PropertyOwnerRepository propertyOwnerRepository;

    @Override
    public PropertyOwner createPropertyOwner(PropertyOwner propertyOwner) {
        validateProperties(propertyOwner.getVatNumber(), propertyOwner.getEmail(), propertyOwner.getPhoneNumber());
        validateUniqueness(propertyOwner.getVatNumber(), propertyOwner.getEmail());
        return propertyOwnerRepository.save(propertyOwner);
    }

    @Override
    public PropertyOwner findPropertyOwnerByVatNumber(String vatNumber) {
        return propertyOwnerRepository.findByVatNumber(vatNumber);
    }

    @Override
    public PropertyOwner findPropertyOwnerByEmail(String email) {
        return propertyOwnerRepository.findByEmail(email);
    }

    @Override
    public boolean updatePropertyOwnerById(Long id, PropertyOwner propertyOwner) {
        Optional<PropertyOwner> tempPropertyOwner = propertyOwnerRepository.findById(id);

        if (tempPropertyOwner.isPresent()) {
            validateProperties(propertyOwner.getVatNumber(), propertyOwner.getEmail(), propertyOwner.getPhoneNumber());
            validateUniquenessForUpdate(propertyOwner.getVatNumber(), propertyOwner.getEmail(), id);

            PropertyOwner existingOwner = tempPropertyOwner.get();

            existingOwner.setVatNumber(propertyOwner.getVatNumber());
            existingOwner.setName(propertyOwner.getName());
            existingOwner.setSurname(propertyOwner.getSurname());
            existingOwner.setEmail(propertyOwner.getEmail());
            existingOwner.setAddress(propertyOwner.getAddress());
            existingOwner.setPhoneNumber(propertyOwner.getPhoneNumber());
            existingOwner.setUsername(propertyOwner.getUsername());
            existingOwner.setPropertyList(propertyOwner.getPropertyList());

            propertyOwnerRepository.save(existingOwner);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePropertyOwnerById(Long id) {
        if (propertyOwnerRepository.existsById(id)) {
            propertyOwnerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PropertyOwner> findAllPropertyOwners() {
        return propertyOwnerRepository.findAll();
    }

    @Override
    public PropertyOwner findPropertyOwnerById(Long id) {
        Optional<PropertyOwner> tempPropertyOwner = propertyOwnerRepository.findById(id);

        if (tempPropertyOwner.isPresent()) {
            PropertyOwner existingPropertyOwner = tempPropertyOwner.get();
            return existingPropertyOwner;
        }
        return null;
    }

    public void validateProperties(String vatNumber, String email, String phoneNumber){
        if (vatNumber == null || !vatNumber.matches("\\d{9}")) {
            throw new VatNumberException("VAT number must be exactly 9 digits: " + vatNumber);
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email == null || !email.matches(emailRegex)) {
            throw new EmailException("Invalid email format: " + email);
        }

        if (phoneNumber == null || !phoneNumber.matches("^[26]\\d{9}$")) {
            throw new PhoneNumberException("Invalid phone number: " + phoneNumber);
        }
    }

    public void validateUniqueness(String vatNumber, String email){
        if (propertyOwnerRepository.existsByVatNumber(vatNumber)) {
            throw new VatNumberException("VAT number already in use: " + vatNumber);
        }

        if (propertyOwnerRepository.existsByEmail(email)) {
            throw new EmailException("Email already in use: " + email);
        }
    }

    public void validateUniquenessForUpdate(String vatNumber, String email, Long id){
        PropertyOwner propertyOwner = propertyOwnerRepository.findByVatNumber(vatNumber);
        if (propertyOwner != null && !propertyOwner.getId().equals(id)) {
            throw new VatNumberException("VAT number already in use by another owner: " + vatNumber);
        }

        PropertyOwner propertyOwner2 = propertyOwnerRepository.findByEmail(email);
        if (propertyOwner2 != null && !propertyOwner2.getId().equals(id)) {
            throw new EmailException("Email already in use by another owner: " + email);
        }
    }
}
