package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairRepository repairRepository;

    @Override
    public Repair createRepair(Repair repair) {
        return repairRepository.createRepair(repair);
    }

    @Override
    public Repair findRepairById(Long id) {
        return repairRepository.findRepairById(id);
    }

    @Override
    public List<Repair> findRepairsByPropertyIdNumber(String propertyIdNumber) {
        return repairRepository.findRepairsByPropertyIdNumber(propertyIdNumber);
    }

    @Override
    public boolean updateRepairById(Long id, Repair repair) {
        return repairRepository.updateRepairById(id, repair);
    }

    @Override
    public boolean deleteRepairById(Long id) {
        return repairRepository.deleteRepairById(id);
    }

    @Override
    public List<Repair> findAllRepairs() {
        return repairRepository.findAllRepairs();
    }
}
