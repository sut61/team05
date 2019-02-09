package com.sut.se.g05.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class Level {
    @Id
    @SequenceGenerator(name = "level_seq", sequenceName = "level_seq")
    @GeneratedValue(generator = "level_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long levelId;
    private @NonNull String levelName;
}
