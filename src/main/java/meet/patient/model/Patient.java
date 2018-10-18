package meet.patient.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Patient {

    String id;

    String name;

    String phone;

    String email;

    String city;

    String country;

}
