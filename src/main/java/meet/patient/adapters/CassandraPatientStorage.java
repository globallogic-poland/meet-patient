package meet.patient.adapters;

import lombok.AllArgsConstructor;
import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import meet.patient.ports.PatientRepository;
import meet.patient.ports.PatientStorage;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CassandraPatientStorage implements PatientStorage {

    private final PatientRepository patientRepository;

    @Override
    public Mono<Patient> findById(PatientKey id) {
        return patientRepository.findById(id);
    }

    @Override
    public Flux<Patient> insert(Publisher<Patient> entities) {
        return patientRepository.insert(entities);
    }

    @Override
    public Flux<Patient> findAll() {
        return patientRepository.findAll();
    }
}
