package com.sut.se.g05.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;

@Data
@Entity

public class Repairinfo {
    @Id
    @SequenceGenerator(name = "repairinfo_seq", sequenceName = "repairinfo_seq")
    @GeneratedValue(generator = "repairinfo_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private @NonNull String phone;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Damage damage;

    public Repairinfo() {}
}
