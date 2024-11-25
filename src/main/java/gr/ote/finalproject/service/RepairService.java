package gr.ote.finalproject.service;

import gr.ote.finalproject.domain.Repair;

import java.time.LocalDateTime;
import java.util.List;

public interface RepairService {
    Repair createRepair(Repair repair);
    Repair findRepairById(Long id);
    List<Repair> findByPropertyId(Long id);
    boolean updateRepairById(Long id, Repair repair);
    boolean deleteRepairById(Long id);
    List<Repair> findAllRepairs();
    List<Repair> getRepairsByDate(LocalDateTime date);
    List<Repair> getRepairsByDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
