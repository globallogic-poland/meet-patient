package meet.patient.ports;

import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientStorage {

    Mono<Patient> findById(PatientKey id);

    Flux<Patient> insert(Flux<Patient> patientFlux);

    Flux<Patient> findAll();

}
