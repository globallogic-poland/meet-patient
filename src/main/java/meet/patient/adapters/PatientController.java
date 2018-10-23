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

    // TODO: add webflux test

    private final PatientStorage patientStorage;

    private final PatientTransformer patientTransformer;

    @GetMapping(path = "/patients", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PatientDto> getAll() {
        return patientStorage.findAll()
                .map(patientTransformer::toDto);
    }

    // TODO: another case for presentation
    /*
    @GetMapping(path = "/patients", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PatientDto> getAll() {
        return Flux.interval(Duration.ofSeconds(1))
                .zipWith(patientStorage.findAll(), (l, p) -> p)
                .map(patientTransformer::toDto);
    }
    */


}
