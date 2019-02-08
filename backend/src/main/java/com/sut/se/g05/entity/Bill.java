package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private String recName;

    private String phone;
    private Date paidDate;
    private Timestamp paidTime;

    @ManyToOne
    private PaidStatus status;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Carry.class)
    @JoinColumn(name = "Cid")
    private Carry carry;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Informationemp.class)
    @JoinColumn(name = "Eid")
    private Informationemp employee;
}
