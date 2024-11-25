package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property") // localhost:8080/api/property
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/check") // localhost:8080/api/property/check - την εφτιαξα κι εγώ για έλεγχο:Ρ
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Property endpoint is working!");
    }

    @PostMapping("/create") // localhost:8080/api/property/create
    public Property createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    @GetMapping("/id/{propertyIdNumber}") // localhost:8080/api/property/id/P001
    public Property findPropertyByPropertyIdNumber(@PathVariable Long propertyIdNumber) {
        return propertyService.findPropertyByPropertyIdNumber(propertyIdNumber);
    }

    @GetMapping("/owner/{vatNumber}") // localhost:8080/api/property/owner/132156888
    public List<Property> findPropertiesByOwnerVat(@PathVariable String vatNumber) {
        return propertyService.findAllByPropertyOwnerVat(vatNumber);
    }

    @GetMapping("/all") // localhost:8080/api/property/all
    public List<Property> findAllProperties() {
        return propertyService.findAllProperties();
    }

    @PutMapping("/{propertyIdNumber}") // localhost:8080/api/property/1
    public boolean updatePropertyByPropertyIdNumber(
            @PathVariable Long propertyIdNumber,
            @RequestBody Property property) {
        return propertyService.updatePropertyByPropertyIdNumber(propertyIdNumber, property);
    }

    @DeleteMapping("/{propertyIdNumber}") // localhost:8080/api/property/1
    public boolean deletePropertyByPropertyIdNumber(@PathVariable Long propertyIdNumber) {
        return propertyService.deletePropertyByPropertyIdNumber(propertyIdNumber);
    }
}
