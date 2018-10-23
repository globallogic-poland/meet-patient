package meet.patient.model;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

@Value
@Builder
@Table
public class Patient {

    @PrimaryKey
    private PatientKey key;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    int age;

    @Column
    String sex;

//    @Singular
//    @Column
//    Set<String> chronicDiseases;

}
