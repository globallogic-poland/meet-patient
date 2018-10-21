package meet.patient.ports;

import meet.patient.model.Patient;
import meet.patient.model.PatientKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends ReactiveCassandraRepository<Patient, PatientKey> {
    
}
