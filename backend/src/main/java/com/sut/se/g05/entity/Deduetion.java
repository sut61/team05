package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Deduetion")
public class Deduetion {

    @Id
    @SequenceGenerator(name = "deduetion_seq", sequenceName = "deduetion_seq")
    @GeneratedValue(generator = "deduetion_seq", strategy = GenerationType.SEQUENCE)
    private Long deduetionid;
    String deduetionnumber;

    public Deduetion() {
    }

    public Deduetion(String deduetionnumber) {

        this.deduetionnumber = deduetionnumber;

    }

}
