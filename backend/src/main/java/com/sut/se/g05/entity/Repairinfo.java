package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode

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

}
