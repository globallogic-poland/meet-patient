package meet.patient.adapters;

import lombok.AllArgsConstructor;
import meet.patient.dto.PatientDto;
import meet.patient.ports.PatientStorage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@RestController
public class PatientController {

    private final PatientStorage patientStorage;

    private final PatientTransformer patientTransformer;

    @GetMapping(path = "/patients", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PatientDto> getAll() {
//        return Flux.interval(Duration.ofSeconds(1)) // TODO: another case for presentation
//                .zipWith(patientStorage.findAll(), (l, patient) -> patient)
        return patientStorage.findAll()
                .map(patientTransformer::toDto);
    }
}
