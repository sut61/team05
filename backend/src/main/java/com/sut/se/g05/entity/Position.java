package com.sut.se.g05.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="Positon")
public class Position {

    @Id
    @SequenceGenerator(name = "pos_seq", sequenceName = "pos_seq")
    @GeneratedValue(generator = "pos_seq", strategy = GenerationType.SEQUENCE)
    private Long positionid;
    String positionlevel;


    public Position(){}

    public Position(String positionlevel){
        this.positionlevel=positionlevel;

    }
}
