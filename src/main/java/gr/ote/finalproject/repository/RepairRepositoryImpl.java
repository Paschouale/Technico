package gr.ote.finalproject.repository;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.enumeration.PropertyType;
import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepairRepositoryImpl implements RepairRepository {

    private static List<Repair> repairList = new ArrayList<>();

    static {

        PropertyOwner owner1 = new PropertyOwner(1L, "132156888", "Dim", "Pas", "Gryp", "698", "test@test.gr", "paschouale", null);
        Property property1 = new Property(1L, null, owner1, PropertyType.APARTMENT, 2005, "Stadiou 10", "P001");
        Repair repair1 = new Repair(1L, LocalDateTime.now(), RepairStatus.STANDBY, RepairType.PAINTING, 500.0, property1, "Painting the living room");
        repairList.add(repair1);
    }

    @Override
    public Repair createRepair(Repair repair) {
        repairList.add(repair);
        return repair;
    }

    @Override
    public Repair findRepairById(Long id) {
        for (Repair repair : repairList) {
            if (repair.getId().equals(id)) {
                return repair;
            }
        }
        return null;
    }

    @Override
    public List<Repair> findRepairsByPropertyIdNumber(String propertyIdNumber) {
        List<Repair> result = new ArrayList<>();
        for (Repair repair : repairList) {
            if (repair.getProperty() != null && repair.getProperty().getPropertyIdNumber().equals(propertyIdNumber)) {
                result.add(repair);
            }
        }
        return result;
    }

    @Override
    public boolean updateRepairById(Long id, Repair repair) {
        Repair existingRepair = findRepairById(id);
        if (existingRepair == null) return false;

        existingRepair.setScheduledRepairDate(repair.getScheduledRepairDate());
        existingRepair.setRepairStatus(repair.getRepairStatus());
        existingRepair.setRepairType(repair.getRepairType());
        existingRepair.setCost(repair.getCost());
        existingRepair.setProperty(repair.getProperty());
        existingRepair.setDescription(repair.getDescription());
        return true;
    }

    @Override
    public boolean deleteRepairById(Long id) {
        Repair repair = findRepairById(id);
        if (repair == null) return false;
        repairList.remove(repair);
        return true;
    }

    @Override
    public List<Repair> findAllRepairs() {
        return repairList;
    }
}
