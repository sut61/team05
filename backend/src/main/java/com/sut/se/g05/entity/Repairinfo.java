package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Optional;

@Getter @Setter
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

    @NotNull @Size(min = 10, max = 10)
    @Pattern(regexp = "^[0]\\d+$")
    @Column (unique = true)
    private String phone;

    @NotNull @Size(min = 3, max = 20)
    @Pattern(regexp = "^[ก-๙a-zA-Z]+$")
    private String employeeName;

    private String note;

    private Date repairDate;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Car.class)
    private Car car;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Driver.class)
    private Driver driver;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Damage.class)
    private Damage damage;

}
