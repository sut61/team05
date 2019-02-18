package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "carControl")
public class Carcontrol {
    @Id
    @SequenceGenerator(name="carControl_seq",sequenceName="carControl_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carControl_seq")
    @Column(name="Carcontrol_ID",unique = true, nullable = false)

    private  Long carcontrolId;
    
    @NotNull
    private  Date time;
    @NotNull
    @Size(min=2,max=100)
    @Pattern(regexp = "^[a-zA-Zก-๙]+$")
	private  String annotation;

	@ManyToOne
	@JoinColumn(name="NameProvince")
	private Province province;

	
	
	@ManyToOne
	@JoinColumn(name="StatusType")
	private CarStatus statusType;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CarInformation.class)
    @JoinColumn(name = "CarInfomation_ID", insertable = true)
    private CarInformation information;




}

