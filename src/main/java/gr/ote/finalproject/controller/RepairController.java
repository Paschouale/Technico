package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair") // localhost:8080/api/repair
public class RepairController {
    @Autowired
    private RepairService repairService;

    @GetMapping("/check") // localhost:8080/api/repair/check
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Repair endpoint is working!");
    }

    @PostMapping("/create") // localhost:8080/api/repair/create
    public Repair createRepair(@RequestBody Repair repair) {
        return repairService.createRepair(repair);
    }

    @GetMapping("/id/{id}") // localhost:8080/api/repair/id/1
    public Repair findRepairById(@PathVariable Long id) {
        return repairService.findRepairById(id);
    }

//    @GetMapping("/property/{propertyIdNumber}") // localhost:8080/api/repair/property/P001
//    public List<Repair> findRepairsByPropertyIdNumber(@PathVariable String propertyIdNumber) {
//        return repairService.findRepairsByPropertyIdNumber(propertyIdNumber);
//    }

    @GetMapping("/all") // localhost:8080/api/repair/all
    public List<Repair> findAllRepairs() {
        return repairService.findAllRepairs();
    }

    @PutMapping("/{id}") // localhost:8080/api/repair/1
    public boolean updateRepairById(@PathVariable Long id, @RequestBody Repair repair) {
        return repairService.updateRepairById(id, repair);
    }

    @DeleteMapping("/{id}") // localhost:8080/api/repair/1
    public boolean deleteRepairById(@PathVariable Long id) {
        return repairService.deleteRepairById(id);
    }
}

