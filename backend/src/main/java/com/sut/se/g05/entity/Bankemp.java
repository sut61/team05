package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name="Bankemp")
public class Bankemp {

    @Id
    @SequenceGenerator(name = "bank_seq", sequenceName = "bank_seq")
    @GeneratedValue(generator = "bank_seq", strategy = GenerationType.SEQUENCE)
    private Long bankempid;
    String bankname;

    public Bankemp(){}
    public Bankemp(String bankname ){

        this.bankname=bankname;
        
    }

}
