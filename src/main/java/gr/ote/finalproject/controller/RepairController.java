package gr.ote.finalproject.controller;

import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/propertyowner/{id}") // localhost:8080/api/repair/propertyowner/1
    public List<Repair> findRepairsByPropertyIdNumber(@PathVariable Long id) {
        return repairService.findByPropertyId(id);
    }

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

    @GetMapping("/date/{date}") //http://localhost:8080/api/repair/date/2024-11-16T15:30:00
    public ResponseEntity<List<Repair>> getRepairsByDate(@PathVariable LocalDateTime date) {
        List<Repair> repairs = repairService.getRepairsByDate(date);
        return ResponseEntity.ok(repairs);
    }

    @GetMapping("/range") //http://localhost:8080/api/repair/range?startDate=2020-11-20T00:00:00&endDate=2024-11-25T23:59:59
    public ResponseEntity<List<Repair>> getRepairsByDateRange(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Repair> repairs = repairService.getRepairsByDateRange(startDate, endDate);
        return ResponseEntity.ok(repairs);
    }
}

