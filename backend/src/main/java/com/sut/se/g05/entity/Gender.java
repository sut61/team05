package com.okta.developer.demo;

import lombok.*;
import javax.persistence.*;


@Data
@Entity
@Table(name="Gender")
public class Gender {

    @Id
    @SequenceGenerator(name = "gen_seq", sequenceName = "gen_seq")
    @GeneratedValue(generator = "gen_seq", strategy = GenerationType.SEQUENCE)
    private Long genderid;
    String sex;

    public Gender(){}
    public Gender(String sex ){

        this.sex=sex;

    }

}
