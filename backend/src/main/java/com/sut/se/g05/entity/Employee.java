package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="Employee")
public class Employee {
    @Id
    @SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq")
    @GeneratedValue(generator = "emp_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = true)
    private Long employeeId;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String username;
    private @NonNull String password;

}
