package meet.patient.adapters;

import lombok.AllArgsConstructor;
import meet.patient.dto.PatientDto;
import meet.patient.model.Patient;
import meet.patient.ports.PatientBindings;
import meet.patient.ports.PatientStorage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import reactor.core.publisher.Flux;

import static meet.patient.ports.PatientBindings.PATIENT_CREATE_REQUESTS;
import static meet.patient.ports.PatientBindings.PATIENT_CREATE_RESULTS;

@AllArgsConstructor
@EnableBinding(PatientBindings.class)
public class PatientProcessor {

    private final PatientStorage patientStorage;

    private final PatientTransformer patientTransformer;

    @StreamListener
    @Output(PATIENT_CREATE_RESULTS)
    public Flux<PatientDto> insert(@Input(PATIENT_CREATE_REQUESTS) Flux<PatientDto> patients) {
        Flux<Patient> patientPublisher = patients
                .map(patientTransformer::fromDto);
        return patientStorage.insert(patientPublisher)
                .map(patientTransformer::toDto);
    }

}
