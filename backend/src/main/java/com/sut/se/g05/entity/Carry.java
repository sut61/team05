package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.groups.Default;

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
    @Pattern(regexp="^([ก-ู]|[เ-์])+")
    private String status;
    @NotNull
    @Size(min=5, max=20)
    @Pattern(regexp="^[A-Z0-9]+$")
    private String carryNumber;

    @ManyToOne
    @JoinColumn(name = "package_ID", insertable = true)
    private  Package packageId;

    @ManyToOne
    @JoinColumn(name = "province_ID", insertable = true)
    private  Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Receiver.class)
    @JoinColumn(name = "Receiver_ID", insertable = true)
    private  Receiver receiver;
    

}

