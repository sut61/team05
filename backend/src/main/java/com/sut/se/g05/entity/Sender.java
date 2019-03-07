package com.sut.se.g05.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name="Sender")
public class Sender {

    @Id
    @SequenceGenerator(name="sender_seq",sequenceName="sender_seq")
    @GeneratedValue(generator="sender_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="SENDER_ID",unique = true, nullable = true)

    @NotNull
    private Long senderId;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @Column(unique = true)
    private String address;
    @NotNull
    @Size(min=5, max=5)
    @Pattern(regexp="^[123456789]\\d+")
    private String postcode;
    @NotNull
    @Size(min=10, max=10)
    @Pattern(regexp = "^0([0-9])+")
    private String phone;
    @NotNull
    private String email;
    @NotNull
    @Pattern(regexp="([a-z]|[A-Z]|[0-9])+")
    private String password;

    //Many To One with Link
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Link.class)
    @JoinColumn(name = "SLId")
    @JsonIgnore
    private Link link;

    //Many To One with Gender
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GId")
    @JsonIgnore
    private Gender gender;

    //Many To One with Provincesen
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "SPSId")
    @JsonIgnore
    private Province province;

}
