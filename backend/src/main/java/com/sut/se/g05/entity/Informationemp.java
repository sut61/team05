package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Informationemp")
public class Informationemp {

    @Id
    @SequenceGenerator(name = "info_seq", sequenceName = "info_seq")
    @GeneratedValue(generator = "info_seq", strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long informationempid;

    @NotNull
    String firstname;

    @NotNull
    String lastname;

    @NotNull
    @Size(min=10, max=10)
    @Pattern(regexp="^[0]\\d+$")
    String phone;

    @NotNull
    String address;

    @NotNull
    String banknumber;

    @NotNull
    String email;

    @NotNull
    String password;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    private Bankemp bankemp;
    @ManyToOne
    private Gender gender;
    @ManyToOne
    private Position position;

//    public void setGender(Optional<Gender> g) {
//    }

//    public Informationemp(String firstname, String lastname, String phone, String address, String banknumber, String email,
//                          String password, Bankemp bankemp, Gender gender, Position position){
//        this.firstname=firstname;
//        this.lastname=lastname;
//        this.phone = phone;
//        this.address=address;
//        this.banknumber = banknumber;
//        this.email = email;
//        this.password = password;
//        this.bankemp=bankemp;
//        this.gender=gender;
//        this.position = position;
//
//
//    }
}



