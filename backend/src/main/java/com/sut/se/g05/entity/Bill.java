package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Bill")
public class Bill {
    @Id
    @SequenceGenerator(name = "bill_seq", sequenceName = "bill_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="bill_seq")
    private Long bid;
    @NotNull @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Zก-๙]+$")
    private String recName;
    @NotNull @Size(min = 10, max = 10) @Pattern(regexp = "^[\\d{10}]+$")
    @Column(unique = true)
    private String phone;
    private Date paidDate;
    private Timestamp paidTime;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaidStatus.class)
    @JoinColumn(name = "psid")
    private PaidStatus status;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Carry.class)
    @JoinColumn(name = "Cid")
    private Carry carry;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Informationemp.class)
    @JoinColumn(name = "Eid")
    private Informationemp employee;
}
