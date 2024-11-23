package gr.ote.finalproject.bootstrap;

import gr.ote.finalproject.domain.PropertyOwner;
import gr.ote.finalproject.repository.PropertyOwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final PropertyOwnerRepository propertyOwnerRepository;

    public void run(ApplicationArguments args){
        propertyOwnerRepository.save(PropertyOwner.builder().vatNumber("132156888").name("Dimitrios").surname("Paschalis").address("Grypari 152").email("paschouale@hotmail.com").username("Paschouale").build());
        propertyOwnerRepository.save(PropertyOwner.builder().vatNumber("123456789").name("Yiota").surname("Plati").address("Grypari 152").phoneNumber("6932667112").username("YiotaPl").build());
        propertyOwnerRepository.save(PropertyOwner.builder().vatNumber("987654321").name("Spyros").surname("Farantos").address("Spiti tou").phoneNumber("6999897654").username("SpyrosF").build());
    }
}
