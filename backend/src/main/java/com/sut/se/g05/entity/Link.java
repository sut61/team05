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
@Table (name="Link")
public class Link {

    @Id
    @SequenceGenerator(name="link_seq",sequenceName="link_seq")
    @GeneratedValue(generator="link_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="LINK_ID",unique = true, nullable = true)

    private Long linkId;

}
