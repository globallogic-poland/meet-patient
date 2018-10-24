package meet.patient;

import meet.patient.dto.Disease;
import meet.patient.dto.PatientDto;
import meet.patient.dto.Sex;
import meet.patient.model.Patient;
import meet.patient.model.PatientKey;

public class DevData {

    public static final PatientDto PATIENT_DTO = PatientDto.builder()
            .id("123")
            .lastName("Smith")
            .firstName("Robert")
            .country("Poland")
            .city("Krakow")
            .district("District1")
            .chronicDisease(Disease.ADHD)
            .sex(Sex.MALE)
            .age(25)
            .build();

    public static final Patient PATIENT = Patient.builder()
            .key(PatientKey.builder()
                    .id("123")
                    .country("Poland")
                    .city("Krakow")
                    .district("District1")
                    .build())
            .lastName("Smith")
            .firstName("Robert")
            .chronicDisease("ADHD")
            .sex(Sex.MALE.toString())
            .age(25)
            .build();

}
