package gr.ote.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "repairs")
@SequenceGenerator(name = "idGenerator", sequenceName = "repair_seq", initialValue = 1, allocationSize = 1)

public class Repair extends BaseDomain{

    private LocalDateTime scheduledRepairDate;
    @Enumerated(EnumType.STRING)
    private RepairStatus repairStatus = RepairStatus.STANDBY;
    @Enumerated(EnumType.STRING)
    private RepairType repairType;
    private Double cost;
    @JsonIgnore
    @ManyToOne
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
