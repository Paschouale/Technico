package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.repository.RepairRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;

    @Override
    public Repair createRepair(Repair repair) {
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

//    @Override
//    public List<Repair> findRepairsByPropertyIdNumber(String propertyIdNumber) {
//        return repairRepository.findRepairsByPropertyIdNumber(propertyIdNumber);
//    }

    @Override
    public boolean updateRepairById(Long id, Repair repair) {
        Optional<Repair> tempRepair = repairRepository.findById(id);

        if (tempRepair.isPresent()) {
            Repair existingRepair = tempRepair.get();

            existingRepair.setScheduledRepairDate(repair.getScheduledRepairDate());
            existingRepair.setRepairStatus(repair.getRepairStatus());
            existingRepair.setRepairType(repair.getRepairType());
            existingRepair.setCost(repair.getCost());
            existingRepair.setProperty(repair.getProperty());
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
}
