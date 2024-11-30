package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.service.PropertyOwnerService;
import gr.ote.finalproject.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/properties") // localhost:8080/api/properties
public class PropertyController {

    private final PropertyService propertyService;
    private final PropertyOwnerService propertyOwnerService;


    @PostMapping("/create") // localhost:8080/api/properties/create
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property createdProperty = propertyService.createProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProperty);
    }

    @GetMapping("/id/{propertyIdNumber}") // localhost:8080/api/properties/id/1
    public ResponseEntity<Property> findPropertyByPropertyIdNumber(@PathVariable Long propertyIdNumber) {
        Property property = propertyService.findPropertyByPropertyIdNumber(propertyIdNumber);
        if (property != null) {
            return ResponseEntity.ok(property);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/propertyOwner/{vatNumber}") // localhost:8080/api/properties/propertyOwner/132156888
    public ResponseEntity<List<Property>> findPropertiesByOwnerVat(@PathVariable String vatNumber) {
        PropertyOwner propertyOwner = propertyOwnerService.findPropertyOwnerByVatNumber(vatNumber);

        if ( propertyOwner == null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<Property> properties = propertyService.findAllByPropertyOwnerVat(vatNumber);
        if (!properties.isEmpty()) {
            return ResponseEntity.ok(properties);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/all") // localhost:8080/api/properties/all
    public ResponseEntity<List<Property>> findAllProperties() {
        List<Property> properties = propertyService.findAllProperties();
        if (!properties.isEmpty()) {
            return ResponseEntity.ok(properties);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{propertyIdNumber}") // localhost:8080/api/properties/1
    public ResponseEntity<String> updatePropertyByPropertyIdNumber(
            @PathVariable Long propertyIdNumber,
            @RequestBody Property property) {
        boolean isUpdated = propertyService.updatePropertyByPropertyIdNumber(propertyIdNumber, property);
        if (isUpdated) {
            return ResponseEntity.ok("Property updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }
    }

    @DeleteMapping("/{propertyIdNumber}") // localhost:8080/api/properties/1
    public ResponseEntity<String> deletePropertyByPropertyIdNumber(@PathVariable Long propertyIdNumber) {
        boolean isDeleted = propertyService.deletePropertyByPropertyIdNumber(propertyIdNumber);
        if (isDeleted) {
            return ResponseEntity.ok("Property deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }
    }
}
