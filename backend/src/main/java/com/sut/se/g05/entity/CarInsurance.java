package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "carInsurance")
public class CarInsurance {
    @Id
    @SequenceGenerator(name="carInsurance_seq",sequenceName="carInsurance_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carInsurance_seq")
    @Column(name="CarInsurance_ID",unique = true, nullable = false)

    private @NonNull Long carInsuranceId;
    private @NonNull String company;

}

