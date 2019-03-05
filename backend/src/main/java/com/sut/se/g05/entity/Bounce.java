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
import java.lang.annotation.Annotation;
import javax.validation.constraints.*;

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
    private String reason;
    @ManyToOne
    private Sender sender;
    @ManyToOne
    private Receiver receiver;
    @ManyToOne
    private Province province;


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
