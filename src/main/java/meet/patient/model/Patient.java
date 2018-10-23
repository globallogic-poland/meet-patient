package meet.patient.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
