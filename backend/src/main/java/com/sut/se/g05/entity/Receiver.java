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
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name="Receiver")
public class Receiver {

    @Id
    @SequenceGenerator(name="receiver_seq",sequenceName="receiver_seq")
    @GeneratedValue(generator="receiver_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="RECEIVER_ID",unique = true, nullable = true)

    private Long receiverId;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull String address;
    private @NonNull String postcode;
    private @NonNull String phone;


    //Many To One with Province
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "RPId")
    @JsonIgnore
    private Province province;

    //Many To One with Link
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Link.class)
    @JoinColumn(name = "RLId")
    @JsonIgnore
    private Link link;

}
