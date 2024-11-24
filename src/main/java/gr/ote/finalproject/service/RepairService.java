package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Repair;
import java.util.List;

public interface RepairService {
    Repair createRepair(Repair repair);
    Repair findRepairById(Long id);
//    List<Repair> findRepairsByPropertyIdNumber(String propertyIdNumber);
    boolean updateRepairById(Long id, Repair repair);
    boolean deleteRepairById(Long id);
    List<Repair> findAllRepairs();
}
