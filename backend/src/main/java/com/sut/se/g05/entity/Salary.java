package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter
@Setter
@ToString
@Table(name = "Salary")
public class Salary {

    @Id
    @SequenceGenerator(name = "salary_seq", sequenceName = "salary_seq")
    @GeneratedValue(generator = "salary_seq", strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long salaryid;

    @NotNull
    @Size(min=5, max=10)
    String name;

    @NotNull
    @Size(min=12, max=12)
    @Pattern(regexp="^[0]\\d+")
    @Column(unique = true)
    String banknumber;

    @NotNull
    Integer balance;
    @NotNull
    String payer;
    @NotNull
    String other;

    @ManyToOne
    private Position position;
    @ManyToOne
    private Bankemp bankemp;
    @ManyToOne
    private Deduetion deduetion;

    public Salary() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Salary(String name, String banknumber, Integer balance,String payer, String other, Position position, Bankemp bankemp,
                  Deduetion deduetion) {
        this.name = name;
        this.banknumber = banknumber;
        this.balance = balance;
        this.payer = payer;
        this.other = other;
        this.position = position;
        this.bankemp = bankemp;
        this.deduetion = deduetion;

    }


}
