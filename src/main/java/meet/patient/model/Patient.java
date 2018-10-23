package meet.patient.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

@Builder
@Getter
@Setter
@Table
public class Patient {

    @PrimaryKey
    private PatientKey key;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String sex;

    @Singular
    @Column
    private Set<String> chronicDiseases;

}
