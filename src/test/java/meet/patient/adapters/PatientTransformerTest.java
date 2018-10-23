package meet.patient.adapters;

import meet.patient.dto.PatientDto;
import meet.patient.model.Patient;
import org.junit.jupiter.api.Test;

import static meet.patient.DevData.PATIENT;
import static meet.patient.DevData.PATIENT_DTO;
import static org.assertj.core.api.Assertions.assertThat;

class PatientTransformerTest {
    
    private final PatientTransformer patientTransformer = new PatientTransformer();

    @Test
    void shouldTransformToDto() {
        PatientDto result = patientTransformer.toDto(PATIENT);
        assertThat(result)
                .isEqualTo(PATIENT_DTO);
    }

    @Test
    void shouldTransformFromDto() {
        Patient result = patientTransformer.fromDto(PATIENT_DTO);
        assertThat(result)
                .isEqualTo(PATIENT);
    }
}