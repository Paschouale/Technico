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

//    List<Repair> findRepairsByPropertyIdNumber(String propertyIdNumber);


//    private static List<Repair> repairList = new ArrayList<>();
//
//    static {
//
//        PropertyOwner owner1 = new PropertyOwner(1L, "132156888", "Dim", "Pas", "Gryp", "698", "test@test.gr", "paschouale", null);
//        Property property1 = new Property(1L, null, owner1, PropertyType.APARTMENT, 2005, "Stadiou 10", "P001");
//        Repair repair1 = new Repair(1L, LocalDateTime.now(), RepairStatus.STANDBY, RepairType.PAINTING, 500.0, property1, "Painting the living room");
//        repairList.add(repair1);
//    }
}
