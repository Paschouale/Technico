package gr.ote.finalproject.bootstrap;

import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.enumeration.PropertyType;
import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import gr.ote.finalproject.repository.PropertyRepository;
import gr.ote.finalproject.repository.RepairRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final PropertyOwnerRepository propertyOwnerRepository;
    private final PropertyRepository propertyRepository;
    private final RepairRepository repairRepository;

    public void run(ApplicationArguments args){
        PropertyOwner propertyOwner1 = PropertyOwner.builder().vatNumber("132156888").name("Dimitrios").surname("Paschalis").address("Grypari 152").email("paschouale@hotmail.com").username("Paschouale").build();

        propertyOwnerRepository.save(propertyOwner1);
        propertyOwnerRepository.save(PropertyOwner.builder().vatNumber("123456789").name("Yiota").surname("Plati").address("Grypari 152").phoneNumber("6932667112").username("YiotaPl").build());
        propertyOwnerRepository.save(PropertyOwner.builder().vatNumber("987654321").name("Spyros").surname("Farantos").address("Spiti tou").phoneNumber("6999897654").username("SpyrosF").build());

        Property property3 = Property.builder().address("Spiti Tou").yearOfConstruction(2024).propertyType(PropertyType.MAISONETTE).propertyOwner(propertyOwner1).repairList(null).build();
        propertyRepository.save(Property.builder().address("Grypari 152").yearOfConstruction(1960).propertyType(PropertyType.APARTMENT).propertyOwner(propertyOwner1).repairList(null).build());
        propertyRepository.save(Property.builder().address("Kalypsous 59").yearOfConstruction(2000).propertyType(PropertyType.DETACHED_HOUSE).propertyOwner(null).repairList(null).build());
        propertyRepository.save(property3);

        repairRepository.save(Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 11, 16, 15, 30)).repairStatus(RepairStatus.PENDING).repairType(RepairType.ELECTRICAL).cost(1200.).property(null).description("Ti eipes?").build());
        repairRepository.save(Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 10, 15, 22, 30)).repairStatus(RepairStatus.INPROGRESS).repairType(RepairType.PLUMBING).cost(2000.).property(null).description("Ti eipa?").build());
        repairRepository.save(Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 9, 14, 9, 30)).repairStatus(RepairStatus.COMPLETE).repairType(RepairType.PAINTING).cost(550.).property(property3).description("Ti eipe?").build());
    }
}
