package gr.ote.finalproject.domain;

import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Repair extends BaseDomain{

    private LocalDateTime scheduledRepairDate;
    private RepairStatus repairStatus = RepairStatus.STANDBY;
    private RepairType repairType;
    private Double cost;
    private Property property; // Για το repair address και owner
    private String description;
}
