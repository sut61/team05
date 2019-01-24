package com.sut.se.g05.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class Damage {
    @Id
    @SequenceGenerator(name = "dameag_seq", sequenceName = "dameag_seq")
    @GeneratedValue(generator = "dameag_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long damageId;
    private @NonNull String damageName;
}
