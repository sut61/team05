package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

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
    private String gender;
}
