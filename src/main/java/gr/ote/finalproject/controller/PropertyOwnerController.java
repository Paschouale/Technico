package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.service.PropertyOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/propertyOwners") //localhost:8080/api/propertyOwners
public class PropertyOwnerController {

    private final PropertyOwnerService propertyOwnerService;

    @PostMapping("/create") //localhost:8080/api/propertyOwners/create
    public ResponseEntity<PropertyOwner> createPropertyOwner(@RequestBody PropertyOwner propertyOwner){
        PropertyOwner createdPropertyOwner = propertyOwnerService.createPropertyOwner(propertyOwner);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPropertyOwner);
    }

    @GetMapping("/vat/{vatNumber}") //localhost:8080/api/propertyOwners/vat/132156888
    public ResponseEntity<PropertyOwner> findPropertyOwnerByVatNumber(@PathVariable String vatNumber){
        PropertyOwner propertyOwner = propertyOwnerService.findPropertyOwnerByVatNumber(vatNumber);
        if (propertyOwner != null){
            return ResponseEntity.ok(propertyOwner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/email/{email}") //localhost:8080/api/propertyOwners/email/test@test.gr
    public ResponseEntity<PropertyOwner> findPropertyOwnerByEmail(@PathVariable String email){
        PropertyOwner propertyOwner = propertyOwnerService.findPropertyOwnerByEmail(email);
        if (propertyOwner != null){
            return ResponseEntity.ok(propertyOwner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all") //localhost:8080/api/propertyOwners/all
    public ResponseEntity<List<PropertyOwner>> findAllPropertyOwners(){
        List<PropertyOwner> propertyOwners = propertyOwnerService.findAllPropertyOwners();
        if (!propertyOwners.isEmpty()){
            return ResponseEntity.ok(propertyOwners);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("{id}") //localhost:8080/api/propertyOwners/1
    public ResponseEntity<String> updatePropertyOwnerById(@PathVariable Long id, @RequestBody PropertyOwner propertyOwner){
        boolean isUpdated =  propertyOwnerService.updatePropertyOwnerById(id, propertyOwner);
        if (isUpdated){
            return ResponseEntity.ok("Property Owner updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property Owner not found.");
        }
    }

    @DeleteMapping("{id}") //localhost:8080/api/propertyOwners/1
    public ResponseEntity<String> deletePropertyOwnerById(@PathVariable Long id){
        boolean isDeleted = propertyOwnerService.deletePropertyOwnerById(id);
        if (isDeleted){
            return ResponseEntity.ok("Property Owner deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property Owner not found.");
        }
    }

}
