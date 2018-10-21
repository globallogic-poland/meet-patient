package meet.patient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.CLUSTERED;
import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Value
@Builder
@AllArgsConstructor
@PrimaryKeyClass
public class PatientKey {

    @PrimaryKeyColumn(type = PARTITIONED)
    String id;

    @PrimaryKeyColumn(type = CLUSTERED, ordinal = 0)
    String country;

    @PrimaryKeyColumn(type = CLUSTERED, ordinal = 1)
    String city;

    @PrimaryKeyColumn(type = CLUSTERED, ordinal = 2)
    String district;

}