package meet.patient.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PatientBindings {

    String PATIENT_CREATE_REQUESTS = "patient-create-requests";
    String PATIENT_CREATE_RESULTS = "patient-create-results";

    @Input(PATIENT_CREATE_REQUESTS)
    SubscribableChannel createPatientRequests();

    @Output(PATIENT_CREATE_RESULTS)
    MessageChannel createPatientResults();
}