package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.Repair;
import java.util.List;

public interface RepairRepository {
    Repair createRepair(Repair repair);
    Repair findRepairById(Long id);
    List<Repair> findRepairsByPropertyIdNumber(String propertyIdNumber);
    boolean updateRepairById(Long id, Repair repair);
    boolean deleteRepairById(Long id);
    List<Repair> findAllRepairs();
}
