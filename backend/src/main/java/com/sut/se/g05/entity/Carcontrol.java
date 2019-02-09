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

    private @NonNull Long carcontrolId;
    private @NonNull Date time;
	private @NonNull String annotation;

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

