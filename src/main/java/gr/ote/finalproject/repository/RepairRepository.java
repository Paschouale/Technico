package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.enumeration.PropertyType;
import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    List<Repair> findAllByPropertyPropertyOwnerId(Long id);
    List<Repair> findAllByScheduledRepairDate(LocalDateTime date);
    List<Repair> findAllByScheduledRepairDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
