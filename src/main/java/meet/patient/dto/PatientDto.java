package meet.patient.dto;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class PatientDto {

    String id;

    String firstName;

    String lastName;

    int age;

    Sex sex;

    @Singular
    Set<String> chronicDiseases;
    
    String country;

    String city;

    String district;

}
