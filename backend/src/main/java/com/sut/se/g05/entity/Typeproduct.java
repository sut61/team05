package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name="Typeproduct")
public class Typeproduct {

    @Id
    @SequenceGenerator(name="typeproduct_seq",sequenceName="typeproduct_seq")
    @GeneratedValue(generator="typeproduct_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="TYPEPRODUCT_ID",unique = true, nullable = true)

    private Long typeproductId;
    private @NonNull String typeproduct;

}
