package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @NotNull
    private @NonNull Long carInsuranceId;
    @NotNull
    @Column(unique = true)
    private @NonNull String company;

    //@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
    // private Collection<Car> carCom;

}

