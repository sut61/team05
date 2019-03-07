package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "carry")
public class Carry {
    @Id
    @SequenceGenerator(name="carry_seq",sequenceName="carry_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carry_seq")  
    @Column(name="Carry_ID",unique = true, nullable = false)

    @NotNull
    private Long carryId;
    @NotNull
    private Date date;
    @NotNull
    @Size(min=5, max=20)
    @Pattern(regexp="^([ก-ู]|[เ-์])+$")
    private String status;
    @NotNull
    @Size(min=5, max=20)
    @Pattern(regexp="^[A-Z0-9]+$")
    @Column(unique = true)
    private String carryNumber;
    @NotNull
    private String namecarry;
    @NotNull
    private String codenamecarry;

    @OneToOne
    @JoinColumn(name = "package_ID")
    private  Package packageId;

    @ManyToOne
    @JoinColumn(name = "province_ID", insertable = true)
    private  Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Receiver.class)
    @JoinColumn(name = "Receiver_ID", insertable = true)
    private  Receiver receiver;

}

