package gr.ote.finalproject.domain;

import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Repair extends BaseDomain{

    private LocalDateTime scheduledRepairDate;
    private RepairStatus repairStatus = RepairStatus.STANDBY;
    private RepairType repairType;
    private Double cost;
    private Property property; // Για το repair address και owner
    private String description;

    public Repair(Long id, LocalDateTime scheduledRepairDate, RepairStatus repairStatus, RepairType repairType, Double cost, Property property, String description) {
        super(id);
        this.scheduledRepairDate = scheduledRepairDate;
        this.repairStatus = repairStatus;
        this.repairType = repairType;
        this.cost = cost;
        this.property = property;
        this.description = description;
    }
}
