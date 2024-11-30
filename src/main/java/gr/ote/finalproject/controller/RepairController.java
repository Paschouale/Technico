package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.service.PropertyOwnerService;
import gr.ote.finalproject.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/repairs") // localhost:8080/api/repairs
public class RepairController {

    private final RepairService repairService;
    private final PropertyOwnerService propertyOwnerService;

    @PostMapping("/create") // localhost:8080/api/repairs/create
    public ResponseEntity<Repair> createRepair(@RequestBody Repair repair) {
        Repair createdRepair = repairService.createRepair(repair);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRepair);
    }

    @GetMapping("/id/{id}") // localhost:8080/api/repairs/id/1
    public ResponseEntity<Repair> findRepairById(@PathVariable Long id) {
        Repair repair = repairService.findRepairById(id);
        if (repair != null) {
            return ResponseEntity.ok(repair);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/propertyOwner/{id}") // localhost:8080/api/repairs/propertyOwner/1
    public ResponseEntity<List<Repair>> findRepairsByPropertyIdNumber(@PathVariable Long id) {
        PropertyOwner propertyOwner = propertyOwnerService.findPropertyOwnerById(id);

        if ( propertyOwner == null ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        List<Repair> repairs = repairService.findByPropertyOwnerId(id);
        if (!repairs.isEmpty()) {
            return ResponseEntity.ok(repairs);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/all") // localhost:8080/api/repairs/all
    public ResponseEntity<List<Repair>> findAllRepairs() {
        List<Repair> repairs = repairService.findAllRepairs();
        if (!repairs.isEmpty()) {
            return ResponseEntity.ok(repairs);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}") // localhost:8080/api/repairs/1
    public ResponseEntity<String> updateRepairById(@PathVariable Long id, @RequestBody Repair repair) {
        boolean isUpdated = repairService.updateRepairById(id, repair);
        if (isUpdated) {
            return ResponseEntity.ok("Property updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }
    }

    @DeleteMapping("/{id}") // localhost:8080/api/repairs/1
    public ResponseEntity<String> deleteRepairById(@PathVariable Long id) {
        boolean isDeleted = repairService.deleteRepairById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Property deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
        }
    }

    @GetMapping("/date/{date}") //http://localhost:8080/api/repairs/date/2024-11-16T15:30:00
    public ResponseEntity<List<Repair>> getRepairsByDate(@PathVariable LocalDateTime date) {
        List<Repair> repairs = repairService.getRepairsByDate(date);
        if (!repairs.isEmpty()) {
            return ResponseEntity.ok(repairs);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/range") //http://localhost:8080/api/repairs/range?startDate=2020-11-20T00:00:00&endDate=2024-11-25T23:59:59
    public ResponseEntity<List<Repair>> getRepairsByDateRange(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Repair> repairs = repairService.getRepairsByDateRange(startDate, endDate);
        if (!repairs.isEmpty())
            return ResponseEntity.ok(repairs);
        else
            return ResponseEntity.noContent().build();
    }
}

