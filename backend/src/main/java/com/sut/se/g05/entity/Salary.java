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
    String banknumber;

    @NotNull
    Integer balance;

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

    public Salary(String name, String banknumber, Integer balance, Position position, Bankemp bankemp,
                  Deduetion deduetion) {
        this.name = name;
        this.banknumber = banknumber;
        this.balance = balance;
        this.position = position;
        this.bankemp = bankemp;
        this.deduetion = deduetion;

    }


}
