package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propertyowner")
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerService propertyOwnerService;

    @PostMapping
    public PropertyOwner createPropertyOwner(@RequestBody PropertyOwner propertyOwner){
        return propertyOwnerService.createPropertyOwner(propertyOwner);
    }

    @GetMapping("{vatNumber}")
    public PropertyOwner findPropertyOwnerByVatNumber(@PathVariable String vatNumber){
        return propertyOwnerService.findPropertyOwnerByVatNumber(vatNumber);
    }

    @GetMapping("{email}")
    public PropertyOwner findPropertyOwnerByEmail(@PathVariable String email){
        return propertyOwnerService.findPropertyOwnerByEmail(email);
    }

    @PutMapping("{vatNumber}/search")
    public boolean updatePropertyOwnerByVatNumber(@PathVariable String vatNumber, @RequestBody PropertyOwner propertyOwner){
        return propertyOwnerService.updatePropertyOwnerByVatNumber(vatNumber, propertyOwner);
    }

    @PutMapping("{email}/search")
    public boolean updatePropertyOwnerByEmail(@PathVariable String email, @RequestBody PropertyOwner propertyOwner){
        return propertyOwnerService.updatePropertyOwnerByEmail(email, propertyOwner);
    }

    @DeleteMapping("{vatNumber}/delete")
    public boolean deletePropertyOwnerByVatNumber(@PathVariable String vatNumber){
        return propertyOwnerService.deletePropertyOwnerByVatNumber(vatNumber);
    }
    @DeleteMapping("{email}/delete")
    public boolean deletePropertyOwnerByEmail(@PathVariable String email){
        return propertyOwnerService.deletePropertyOwnerByEmail(email);
    }
}
