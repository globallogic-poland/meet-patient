package meet.patient.ports;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PatientBindings {

    String PATIENT_CREATE_REQUESTS = "patient-create-requests";
    String PATIENT_CREATE_RESULTS = "patient-create-results";

    String PATIENT_GET_REQUESTS = "patient-get-requests";
    String PATIENT_GET_RESULTS = "patient-get-results";
    
    @Input(PATIENT_CREATE_REQUESTS)
    SubscribableChannel createPatientRequests();

    @Output(PATIENT_CREATE_RESULTS)
    MessageChannel createPatientResults();

    @Input(PATIENT_GET_REQUESTS)
    SubscribableChannel findAllRequests();

    @Output(PATIENT_GET_RESULTS)
    MessageChannel findAllResults();
}