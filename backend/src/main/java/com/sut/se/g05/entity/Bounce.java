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
@Table (name="Bounce")
public class Bounce {

    @Id
    @SequenceGenerator(name="bounce_seq",sequenceName="bounce_seq")
    @GeneratedValue(generator="bounce_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="BOUNCE_ID",unique = true, nullable = true)

    @NotNull
    private Long bounceId;
    @NotNull
    @Size(min=5, max=100)
    @Pattern(regexp="([ก-ฮ])+")
    private String reason;
    @NotNull
    private String sender;
    @NotNull
    private String receiver;
    @NotNull
    private String province;


    //Many To One with Linksen
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Linksen.class)
    @JoinColumn(name = "BSId")
    @JsonIgnore
    private Linksen linksen;


    //Many To One with Typeproduct
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Typeproduct.class)
    @JoinColumn(name = "BTId")
    @JsonIgnore
    private Typeproduct typeproduct;

}
