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

    private Long senderId;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String address;
    private @NonNull String postcode;
    private @NonNull String phone;
    private @NonNull String email;
    private @NonNull String password;

    //Many To One with Link
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Link.class)
    @JoinColumn(name = "SLId")
    @JsonIgnore
    private Link link;

    //Many To One with Provincesen
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Provincesen.class)
    @JoinColumn(name = "SPSId")
    @JsonIgnore
    private Provincesen provincesen;

}
