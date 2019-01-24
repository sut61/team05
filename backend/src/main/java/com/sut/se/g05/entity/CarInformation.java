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

 

    public Long getcarInformationId() {
        return carInformationId;
    }

    public void setCarInformationId(Long carInformationId) {
        this.carInformationId = carInformationId;
    }

    
    public String getName(){
        return name;
    } 

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return address;
    } 
    public void setName(String name){
        this.name=name;
    }

    public String getTelephone(){
        return telephone;
    } 

    public void setTelephone(String telephone){
        this.telephone=telephone;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age=age;
    }

	public void setGender(Gender g) {
        this.gender=g;
	}
    public void setProvince(Province p) {
        this.province=p;
    }
   
	public void setCarbrand(Car cc2) {
        this.car=cc2;
    }




    
   
}