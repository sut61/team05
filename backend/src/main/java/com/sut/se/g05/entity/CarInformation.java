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
   
    private @NonNull Long carInformationId;
    
    private String name;
    private String address;
    private String telephone;
    private Integer age;
    
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