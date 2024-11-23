package gr.ote.finalproject.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import gr.ote.finalproject.domain.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {

    PropertyOwner findByVatNumber(String vatNumber);
    PropertyOwner findByEmail(String email);

//    PropertyOwner createPropertyOwner(PropertyOwner propertyOwner);
//    PropertyOwner findPropertyOwnerByVatNumber(String vatNumber);
//    PropertyOwner findPropertyOwnerByEmail(String email);
//    boolean updatePropertyOwnerByVatNumber(String vatNumber, PropertyOwner propertyOwner);
//    boolean deletePropertyOwnerByVatNumber(String vatNumber);
//    List<PropertyOwner> findAllPropertyOwner();


//    private static List<PropertyOwner> propertyOwnerList = new ArrayList<>();
//
//    static {
//        propertyOwnerList.add(new PropertyOwner(1L,"132156888", "Dim","Pas","Gryp",
//                "698","test@test.gr", "paschouale", null));
//        propertyOwnerList.add(PropertyOwner.builder().id(2L).vatNumber("123").name("Jim").surname("Pas").
//               address("Gryp").phoneNumber("698").email("t@t.gr").username("tot").propertyList(null).build());
//    }
}
