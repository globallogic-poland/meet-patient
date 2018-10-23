package meet.patient.adapters;

import meet.patient.dto.PatientDto;
import meet.patient.dto.Sex;
import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import org.springframework.stereotype.Component;

@Component
public class PatientTransformer {

    public PatientDto toDto(Patient patient) {
        return PatientDto.builder()
                .age(patient.getAge())
                .sex(Sex.valueOf(patient.getSex()))
                .country(patient.getKey().getCountry())
                .city(patient.getKey().getCity())
                .district(patient.getKey().getDistrict())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .id(patient.getKey().getId())
//                .chronicDiseases(patient.getChronicDiseases())
                .build();
    }

    public Patient fromDto(PatientDto patientDto) {
        return Patient.builder()
                .key(PatientKey.builder()
                        .id(patientDto.getId())
                        .country(patientDto.getCountry())
                        .city(patientDto.getCity())
                        .district(patientDto.getDistrict())
                        .build())
                .age(patientDto.getAge())
                .sex(patientDto.getSex().toString())
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
//                .chronicDiseases(patientDto.getChronicDiseases())
                .build();
    }
}
