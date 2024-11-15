package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/propertyowner") //localhost:8080/api/propertyowner
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerService propertyOwnerService;

    @GetMapping("/check") //Αγνοήστε αυτή την έφτιαξα για έλεγχο
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("PropertyOwner endpoint is working!");
    }

    @PostMapping("/create") //localhost:8080/api/propertyowner/create
    public PropertyOwner createPropertyOwner(@RequestBody PropertyOwner propertyOwner){
        return propertyOwnerService.createPropertyOwner(propertyOwner);
    }

    @GetMapping("/vat/{vatNumber}") //localhost:8080/api/propertyowner/vat/132156888
    public PropertyOwner findPropertyOwnerByVatNumber(@PathVariable String vatNumber){
        return propertyOwnerService.findPropertyOwnerByVatNumber(vatNumber);
    }

    @GetMapping("/email/{email}") //localhost:8080/api/propertyowner/email/test@test.gr
    public PropertyOwner findPropertyOwnerByEmail(@PathVariable String email){
        return propertyOwnerService.findPropertyOwnerByEmail(email);
    }

    @GetMapping("/all") //localhost:8080/api/propertyowner/all
    public List<PropertyOwner> findAllPropertyOwners(){
        return propertyOwnerService.findAllPropertyOwners();
    }

    @PutMapping("{vatNumber}") //localhost:8080/api/propertyowner/132156888
    public boolean updatePropertyOwnerByVatNumber(@PathVariable String vatNumber, @RequestBody PropertyOwner propertyOwner){
        return propertyOwnerService.updatePropertyOwnerByVatNumber(vatNumber, propertyOwner);
    }

    @DeleteMapping("{vatNumber}") //localhost:8080/api/propertyowner/132156888
    public boolean deletePropertyOwnerByVatNumber(@PathVariable String vatNumber){
        return propertyOwnerService.deletePropertyOwnerByVatNumber(vatNumber);
    }

}
