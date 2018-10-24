package meet.patient.adapters;

import meet.patient.dto.Disease;
import meet.patient.dto.PatientDto;
import meet.patient.dto.Sex;
import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientTransformer {

    public PatientDto toDto(Patient patient) {

        List<Disease> diseases = patient.getChronicDiseases().stream()
                .map(Disease::valueOf)
                .collect(Collectors.toList());

        PatientKey key = patient.getKey();

        return PatientDto.builder()
                .age(patient.getAge())
                .sex(Sex.valueOf(patient.getSex()))
                .country(key.getCountry())
                .city(key.getCity())
                .district(key.getDistrict())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .id(key.getId())
                .chronicDiseases(diseases)
                .build();
    }

    public Patient fromDto(PatientDto patientDto) {

        List<String> diseases = patientDto.getChronicDiseases().stream()
                .map(Enum::toString)
                .collect(Collectors.toList());

        PatientKey patientKey = PatientKey.builder()
                .id(patientDto.getId())
                .country(patientDto.getCountry())
                .city(patientDto.getCity())
                .district(patientDto.getDistrict())
                .build();

        return Patient.builder()
                .key(patientKey)
                .age(patientDto.getAge())
                .sex(patientDto.getSex().toString())
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .chronicDiseases(diseases)
                .build();
    }
}
