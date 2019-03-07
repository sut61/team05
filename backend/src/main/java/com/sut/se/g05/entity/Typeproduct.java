package com.sut.se.g05.entity;

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
@Table (name="Typeproduct")
public class Typeproduct {

    @Id
    @SequenceGenerator(name="typeproduct_seq",sequenceName="typeproduct_seq")
    @GeneratedValue(generator="typeproduct_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="TYPEPRODUCT_ID",unique = true, nullable = true)

    @NotNull
    private Long typeproductId;
    @NotNull
    @Size(min=5, max=100)
    @Column(unique = true)
    private String typeproduct;

}
