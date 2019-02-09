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
@Table (name="Linksen")
public class Linksen {

    @Id
    @SequenceGenerator(name="linksen_seq",sequenceName="linksen_seq")
    @GeneratedValue(generator="linksen_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="LINKSEN_ID",unique = true, nullable = true)

    private Long linksenId;

}
