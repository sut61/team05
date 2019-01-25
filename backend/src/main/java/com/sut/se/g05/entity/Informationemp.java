package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@Table(name="Informationemp")
public class Informationemp {

    @Id
    @SequenceGenerator(name = "info_seq", sequenceName = "info_seq")
    @GeneratedValue(generator = "info_seq", strategy = GenerationType.SEQUENCE)
    private Long informationempid;
    String firstname;
    String lastname;
    String phone;
    String address;
    String banknumber;
    String email;
    String password;

    @ManyToOne
    private Bankemp bankemp;
    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Position position;

    public Informationemp(){}

    public Informationemp(String firstname,String lastname,String phone,String address,String banknumber,String email,
                          String password,Bankemp bankemp,Gender gender,Position position){
        this.firstname=firstname;
        this.lastname=lastname;
        this.phone = phone;
        this.address=address;
        this.banknumber = banknumber;
        this.email = email;
        this.password = password;
        this.bankemp=bankemp;
        this.gender=gender;
        this.position = position;


    }

    public void setGender(Optional<Gender> g) {
    }
}



