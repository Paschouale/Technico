package gr.ote.finalproject.bootstrap;

import gr.ote.finalproject.domain.LoginUser;
import gr.ote.finalproject.domain.Property;
import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.domain.Repair;
import gr.ote.finalproject.enumeration.PropertyType;
import gr.ote.finalproject.enumeration.RepairStatus;
import gr.ote.finalproject.enumeration.RepairType;
import gr.ote.finalproject.enumeration.Role;
import gr.ote.finalproject.repository.LoginUserRepository;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import gr.ote.finalproject.repository.PropertyRepository;
import gr.ote.finalproject.repository.RepairRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final PropertyOwnerRepository propertyOwnerRepository;
    private final PropertyRepository propertyRepository;
    private final RepairRepository repairRepository;
    private final LoginUserRepository loginUserRepository;

    public void run(ApplicationArguments args){

        List<PropertyOwner> propertyOwners = List.of(
                PropertyOwner.builder().vatNumber("132156888").name("Dimitrios").surname("Paschalis")
                        .address("Grypari 152").phoneNumber("6982848470").email("paschouale@hotmail.com").build(),
                PropertyOwner.builder().vatNumber("123456789").name("Yiota").surname("Plati")
                        .address("Grypari 152").phoneNumber("6932667112").email("pplati@gmail.com").build(),
                PropertyOwner.builder().vatNumber("987654321").name("Spyros").surname("Farantos")
                        .address("Spiti tou").phoneNumber("6999897654").email("sfantos@gmail.com").build(),
                PropertyOwner.builder().vatNumber("246813579").name("Maria").surname("Nikolaou")
                        .address("Kolonaki 18").phoneNumber("6971234567").email("mniko@gmail.com").build(),
                PropertyOwner.builder() .vatNumber("135792468").name("Kostas").surname("Papadopoulos")
                        .address("Panormou 34").phoneNumber("6945123412").email("kpapa@hotmail.com").build(),
                PropertyOwner.builder().vatNumber("192837465").name("Eleni").surname("Dimitriou")
                        .address("Nea Smyrni 45").phoneNumber("6932789456").email("eleni.d@gmail.com").build(),
                PropertyOwner.builder().vatNumber("384756192").name("Giorgos").surname("Kontos")
                        .address("Marousi 78").phoneNumber("6983456789").email("kontos@gmail.com").build(),
                PropertyOwner.builder().vatNumber("564738291").name("Ioanna").surname("Tsoukalas")
                        .address("Glyfada 99").phoneNumber("6901230987").email("itsoukalas@gmail.com").build(),
                PropertyOwner.builder().vatNumber("837465291").name("Nikos").surname("Vlachos")
                        .address("Halandri 12").phoneNumber("6945678921").email("nvla@gmail.com").build(),
                PropertyOwner.builder().vatNumber("928374651").name("Anna").surname("Karagiorgi")
                        .address("Kifisia 23").phoneNumber("6987654321").email("akaragiorgi@gmail.com").build()
        );

        propertyOwnerRepository.saveAll(propertyOwners);

        List<Property> properties = List.of(
                Property.builder().numberE9("Ε9-12340").address("Grypari 152").yearOfConstruction(2024)
                        .propertyType(PropertyType.MAISONETTE).propertyOwner(propertyOwners.get(0)).build(),
                Property.builder().numberE9("Ε9-12341").address("Kalypsous 59").yearOfConstruction(1960).
                        propertyType(PropertyType.APARTMENT).propertyOwner(propertyOwners.get(1)).build(),
                Property.builder().numberE9("Ε9-12342").address("Alexandras 23").yearOfConstruction(2000).
                        propertyType(PropertyType.DETACHED_HOUSE).propertyOwner(propertyOwners.get(2)).build(),
                Property.builder().numberE9("Ε9-12343").address("Kolonaki 18").yearOfConstruction(2010)
                        .propertyType(PropertyType.APARTMENT).propertyOwner(propertyOwners.get(3)).build(),
                Property.builder().numberE9("Ε9-12344").address("Panormou 34").yearOfConstruction(1985)
                        .propertyType(PropertyType.APARTMENT).propertyOwner(propertyOwners.get(4)).build(),
                Property.builder().numberE9("Ε9-12345").address("Nea Smyrni 45").yearOfConstruction(1995)
                        .propertyType(PropertyType.MAISONETTE).propertyOwner(propertyOwners.get(5)).build(),
                Property.builder().numberE9("Ε9-12346").address("Marousi 78").yearOfConstruction(1970)
                        .propertyType(PropertyType.DETACHED_HOUSE).propertyOwner(propertyOwners.get(6)).build(),
                Property.builder().numberE9("Ε9-12347").address("Glyfada 99").yearOfConstruction(2020)
                        .propertyType(PropertyType.MAISONETTE).propertyOwner(propertyOwners.get(7)).build(),
                Property.builder().numberE9("Ε9-12348").address("Halandri 12").yearOfConstruction(2015)
                        .propertyType(PropertyType.MAISONETTE).propertyOwner(propertyOwners.get(8)).build(),
                Property.builder().numberE9("Ε9-12349").address("Kifisia 23").yearOfConstruction(1990)
                        .propertyType(PropertyType.DETACHED_HOUSE).propertyOwner(propertyOwners.get(9)).build()
        );

        propertyRepository.saveAll(properties);


        List<Repair> repairs = List.of(
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 9, 14, 9, 30))
                        .repairStatus(RepairStatus.COMPLETE).repairType(RepairType.PAINTING).cost(550.)
                        .property(properties.get(0)).description("Living Room Painting").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 11, 16, 15, 30))
                        .repairStatus(RepairStatus.PENDING).repairType(RepairType.ELECTRICAL).cost(1200.)
                        .property(properties.get(1)).description("Electrical Board problem").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 10, 15, 22, 30))
                        .repairStatus(RepairStatus.INPROGRESS).repairType(RepairType.PLUMBING).cost(2000.)
                        .property(properties.get(2)).description("Kitchen pipe broke down").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 12, 5, 14, 0))
                        .repairStatus(RepairStatus.STANDBY).repairType(RepairType.PAINTING).cost(400.)
                        .property(properties.get(3)).description("Bathroom repainting").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 8, 20, 9, 0))
                        .repairStatus(RepairStatus.COMPLETE).repairType(RepairType.ELECTRICAL).cost(300.)
                        .property(properties.get(4)).description("Fixing lighting issues in bedroom").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 11, 10, 11, 0))
                        .repairStatus(RepairStatus.PENDING).repairType(RepairType.PLUMBING).cost(750.)
                        .property(properties.get(5)).description("Water heater repair").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 12, 12, 16, 0))
                        .repairStatus(RepairStatus.INPROGRESS).repairType(RepairType.PAINTING).cost(1000.)
                        .property(properties.get(6)).description("Exterior wall painting").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 7, 19, 10, 30))
                        .repairStatus(RepairStatus.STANDBY).repairType(RepairType.ELECTRICAL).cost(1500.)
                        .property(properties.get(7)).description("Full electrical inspection").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 9, 5, 13, 30))
                        .repairStatus(RepairStatus.COMPLETE).repairType(RepairType.PLUMBING).cost(500.)
                        .property(properties.get(8)).description("Fixing pipe leaks in basement").build(),
                Repair.builder().scheduledRepairDate(LocalDateTime.of(2024, 10, 22, 15, 30))
                        .repairStatus(RepairStatus.PENDING).repairType(RepairType.PAINTING).cost(250.)
                        .property(properties.get(9)).description("Repainting the main hallway").build()
        );

        repairRepository.saveAll(repairs);


        List<LoginUser> loginUsers = List.of(
                LoginUser.builder().username("admin").password("1234").role(Role.ADMIN).build(),
                LoginUser.builder().username("dpaschal").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(0)).build(),
                LoginUser.builder().username("yplati").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(1)).build(),
                LoginUser.builder().username("sfarantos").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(2)).build(),
                LoginUser.builder().username("mnikolaou").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(3)).build(),
                LoginUser.builder().username("kpapa").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(4)).build(),
                LoginUser.builder().username("edimitriou").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(5)).build(),
                LoginUser.builder().username("gkontos").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(6)).build(),
                LoginUser.builder().username("itsoukalas").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(7)).build(),
                LoginUser.builder().username("nvlachos").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(8)).build(),
                LoginUser.builder().username("akaragiorgi").password("1234").role(Role.PROPERTY_OWNER)
                        .propertyOwner(propertyOwners.get(9)).build()
        );

        loginUserRepository.saveAll(loginUsers);
    }
}
