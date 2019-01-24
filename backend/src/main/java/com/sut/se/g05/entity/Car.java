package com.sut.se.g05.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Car")
public class Car {
    
    @Id
    @SequenceGenerator(name="car_seq",sequenceName="car_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="car_seq")  
    @Column(name="carId",unique = true, nullable = true)
    
    private @NonNull Long carId;
    private String carbrand;
    private String licenseplate;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }
    public String getlicenseplate() {
        return licenseplate;
    }

    public void setlicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }
}