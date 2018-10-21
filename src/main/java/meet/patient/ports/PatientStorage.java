package meet.patient.ports;

import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientStorage {

    Mono<Patient> findById(PatientKey id);

    Flux<Patient> insert(Publisher<Patient> entities);

    Flux<Patient> findAll();

}
