package com.sut.se.g05.entity;
import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CarInformation")
public class CarInformation {
    @Id
    @SequenceGenerator(name="carinformation_seq",sequenceName="carinformation_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carinformation_seq")  
    @Column(name="carinformationId",unique = true, nullable = false)
   
    private  Long carInformationId;
    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp = "^[a-z A-Zก-ฮ]+$")
    private   String name;

    @NotNull
    private   String address;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^[0]\\d+$")
    private   String telephone;
    
    @NotNull
    private   Integer age;
    
    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "genderId")
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "provinceId")
    private Province province;

    //public void setGender(Optional<Gender> g) {}
}