package com.sut.se.g05.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Status")
public class PaidStatus {
    @Id
    @SequenceGenerator(name = "s_seq", sequenceName = "s_seq")
    @GeneratedValue(generator = "s_seq",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String status;
}
