package meet.patient.adapters;

import lombok.AllArgsConstructor;
import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import meet.patient.ports.PatientRepository;
import meet.patient.ports.PatientStorage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CassandraPatientStorage implements PatientStorage {

    private final PatientRepository patientRepository;

    @Override
    public Mono<Patient> findById(PatientKey id) {
        return patientRepository.findById(id);
    }

    @Override
    public Flux<Patient> insert(Flux<Patient> patientFlux) {
        return patientRepository.insert(
                patientFlux.map(patient -> {
                    patient.getKey().setId(UUID.randomUUID().toString());
                    return patient;
                }));
    }

    @Override
    public Flux<Patient> findAll() {
        return patientRepository.findAll();
    }
}
