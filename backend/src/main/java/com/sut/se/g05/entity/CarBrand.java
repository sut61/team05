package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.CascadeType;
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
@Table(name = "carBrand")
public class CarBrand {
    @Id
    @SequenceGenerator(name="carBrand_seq",sequenceName="carBrand_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carBrand_seq")
    @Column(name="CarBrand_ID",unique = true, nullable = false)

    private @NonNull Long carBrandId;
    private @NonNull String brand;

}

