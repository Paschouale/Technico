package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.exception.ResourceNotFoundException;
import gr.ote.finalproject.repository.PropertyRepository;
import gr.ote.finalproject.repository.RepairRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public Repair createRepair(Repair repair) {
        Long propertyId = repair.getProperty().getId();
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));

        repair.setProperty(property);

        return repairRepository.save(repair);
    }

    @Override
    public Repair findRepairById(Long id) {
        Optional<Repair> tempRepair = repairRepository.findById(id);

        if (tempRepair.isPresent()) {
            Repair existingRepair = tempRepair.get();
            return existingRepair;
        }
        return null;
    }

    @Override
    public List<Repair> findByPropertyOwnerId(Long id) {
        return repairRepository.findAllByPropertyPropertyOwnerId(id);
    }

    @Override
    public boolean updateRepairById(Long id, Repair repair) {
        Optional<Repair> tempRepair = repairRepository.findById(id);

        if (tempRepair.isPresent()) {
            Repair existingRepair = tempRepair.get();

            existingRepair.setScheduledRepairDate(repair.getScheduledRepairDate());
            existingRepair.setRepairStatus(repair.getRepairStatus());
            existingRepair.setRepairType(repair.getRepairType());
            if (!isEmptyOrNullOrBlankDouble(repair.getCost()))
                existingRepair.setCost(repair.getCost());
            //existingRepair.setProperty(repair.getProperty());
            existingRepair.setDescription(repair.getDescription());

            repairRepository.save(existingRepair);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRepairById(Long id) {
        if (repairRepository.existsById(id)) {
            repairRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Repair> findAllRepairs() {
        return repairRepository.findAll();
    }

    public List<Repair> getRepairsByDate(LocalDateTime date) {
        return repairRepository.findAllByScheduledRepairDate(date);
    }

    public List<Repair> getRepairsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return repairRepository.findAllByScheduledRepairDateBetween(startDate, endDate);
    }

    private boolean isEmptyOrNullOrBlankDouble(Double doubleToBeChecked) {
        return doubleToBeChecked == null || doubleToBeChecked == 0.0;
    }
}
