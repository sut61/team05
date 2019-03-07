package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name="Gender")
public class Gender {

    @Id
    @SequenceGenerator(name="gender_seq",sequenceName="gender_seq")
    @GeneratedValue(generator="gender_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="GENDER_ID",unique = true, nullable = true)

    private Long genderId;
    @NotNull
    @Column(unique = true)
    private @NonNull String gender;

}
