package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.*;

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
    private @NonNull String firstname;
    @NotNull
    private @NonNull String lastname;
    @NotNull
    @Column(unique = true)
    private @NonNull String address;
    @NotNull
    @Size(min=5, max=5)
    @Pattern(regexp="^[123456789]\\d+")
    private @NonNull String postcode;
    @NotNull
    @Size(min=10, max=10)
    @Pattern(regexp = "^0([0-9])+")
    private @NonNull String phone;
    @NotNull
    private @NonNull String email;
    @NotNull
    @Pattern(regexp="([a-z]|[A-Z]|[0-9])+")
    private @NonNull String password;

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
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Provincesen.class)
    @JoinColumn(name = "SPSId")
    @JsonIgnore
    private Provincesen provincesen;

}
