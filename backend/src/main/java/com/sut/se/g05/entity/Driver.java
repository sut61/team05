package com.sut.se.g05.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class Driver {
    @Id
    @SequenceGenerator(name = "driver_seq", sequenceName = "driver_seq")
    @GeneratedValue(generator = "driver_seq", strategy = GenerationType.SEQUENCE)
    private @NonNull Long driverId;
    private @NonNull String driverName;
}

