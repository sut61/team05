package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "car")
public class Car {
    @Id
    @SequenceGenerator(name="car_seq",sequenceName="car_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="car_seq")
    @Column(name="Car_ID",unique = true, nullable = false)

	@NotNull
	private @NonNull Long carId;
	@NotNull
	@Size(min=5, max=10)
	@Pattern(regexp="^[ก-ฮ0-9]+$")
	private String licenseplate;

	@ManyToOne
	@JoinColumn(name="CarBrand_Name")
	private CarBrand brand;
	
	@ManyToOne
	@JoinColumn(name="CarInsurance_Name")
	private CarInsurance company;
	
	@ManyToOne
	@JoinColumn(name="Province_Name")
    private Province province;




}

