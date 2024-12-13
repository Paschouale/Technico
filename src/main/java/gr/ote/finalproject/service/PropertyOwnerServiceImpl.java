package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.LoginUser;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.enumeration.Role;
import gr.ote.finalproject.exception.EmailException;
import gr.ote.finalproject.exception.GenericBusinessException;
import gr.ote.finalproject.exception.PhoneNumberException;
import gr.ote.finalproject.exception.VatNumberException;
import gr.ote.finalproject.repository.LoginUserRepository;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropertyOwnerServiceImpl implements PropertyOwnerService {

    private final PropertyOwnerRepository propertyOwnerRepository;
    private final LoginUserRepository loginUserRepository;

    @Override
    public PropertyOwner createPropertyOwner(PropertyOwner propertyOwner) {
        validateProperties(propertyOwner.getVatNumber(), propertyOwner.getEmail(), propertyOwner.getPhoneNumber(), propertyOwner.getLoginUser().getUsername(), propertyOwner.getLoginUser().getPassword());
        validateUniqueness(propertyOwner.getVatNumber(), propertyOwner.getEmail(), propertyOwner.getLoginUser().getUsername());

        propertyOwner.getLoginUser().setRole(Role.PROPERTY_OWNER);
        propertyOwner.getLoginUser().setPropertyOwner(propertyOwner);

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
            PropertyOwner existingOwner = tempPropertyOwner.get();

            if (!isEmptyOrNullOrBlankString(propertyOwner.getVatNumber())) {
                existingOwner.setVatNumber(propertyOwner.getVatNumber());
            }
            if (!isEmptyOrNullOrBlankString(propertyOwner.getName())) {
                existingOwner.setName(propertyOwner.getName());
            }
            if (!isEmptyOrNullOrBlankString(propertyOwner.getSurname())) {
                existingOwner.setSurname(propertyOwner.getSurname());
            }
            if (!isEmptyOrNullOrBlankString(propertyOwner.getEmail())) {
                existingOwner.setEmail(propertyOwner.getEmail());
            }
            if (!isEmptyOrNullOrBlankString(propertyOwner.getAddress())) {
                existingOwner.setAddress(propertyOwner.getAddress());
            }
            if (!isEmptyOrNullOrBlankString(propertyOwner.getPhoneNumber())) {
                existingOwner.setPhoneNumber(propertyOwner.getPhoneNumber());
            }

            if (propertyOwner.getLoginUser() != null) {
                    LoginUser existingLoginUser = existingOwner.getLoginUser();

                    if (!isEmptyOrNullOrBlankString(propertyOwner.getLoginUser().getUsername())) {
                        existingLoginUser.setUsername(propertyOwner.getLoginUser().getUsername());
                    }

                    if (!isEmptyOrNullOrBlankString(propertyOwner.getLoginUser().getPassword())) {
                        existingLoginUser.setPassword(propertyOwner.getLoginUser().getPassword());
                    }

                existingLoginUser.setRole(Role.PROPERTY_OWNER);
            }

            if (propertyOwner.getPropertyList() != null) {
                existingOwner.setPropertyList(propertyOwner.getPropertyList());
            }

            validateProperties(
                    existingOwner.getVatNumber(),
                    existingOwner.getEmail(),
                    existingOwner.getPhoneNumber(),
                    existingOwner.getLoginUser().getUsername(),
                    existingOwner.getLoginUser().getPassword()
            );
            validateUniquenessForUpdate(
                    existingOwner.getVatNumber(),
                    existingOwner.getEmail(),
                    id,
                    existingOwner.getLoginUser().getUsername(),
                    existingOwner.getLoginUser().getId()
            );

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

    public void validateProperties(String vatNumber, String email, String phoneNumber, String username, String password) {
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

        if (username == null || username.length() <= 4) {
            throw new IllegalArgumentException("Username must be more than 4 characters.");
        }
        if (password == null || password.length() <= 3) {
            throw new IllegalArgumentException("Password must be more than 3 characters.");
        }
    }

    public void validateUniqueness(String vatNumber, String email, String username) {
        if (propertyOwnerRepository.existsByVatNumber(vatNumber)) {
            throw new VatNumberException("VAT number already in use: " + vatNumber);
        }

        if (propertyOwnerRepository.existsByEmail(email)) {
            throw new EmailException("Email already in use: " + email);
        }

        if (loginUserRepository.existsByUsername(username)) {
            throw new GenericBusinessException("Username already exists: " + username);
        }
    }

    private boolean isEmptyOrNullOrBlankString(String stringToBeChecked){
        return stringToBeChecked == null || stringToBeChecked.isBlank() || stringToBeChecked.isEmpty();
    }

    public void validateUniquenessForUpdate(String vatNumber, String email, Long id, String username, Long loginUserId) {
        PropertyOwner propertyOwner = propertyOwnerRepository.findByVatNumber(vatNumber);
        if (propertyOwner != null && !propertyOwner.getId().equals(id)) {
            throw new VatNumberException("VAT number already in use by another owner: " + vatNumber);
        }

        PropertyOwner propertyOwner2 = propertyOwnerRepository.findByEmail(email);
        if (propertyOwner2 != null && !propertyOwner2.getId().equals(id)) {
            throw new EmailException("Email already in use by another owner: " + email);
        }

        LoginUser loginUser = loginUserRepository.findByUsername(username);
        if (loginUser != null && !loginUser.getId().equals(loginUserId)) {
            throw new IllegalArgumentException("Username already in use by another owner: " + username);
        }
    }
}
