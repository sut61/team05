package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "carStatus")
public class CarStatus {
    @Id
    @SequenceGenerator(name="carStatus_seq",sequenceName="carStatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carStatus_seq")
    @Column(name="CarStatus_ID",unique = true, nullable = false)

    private @NonNull Long carStatusId;
    private @NonNull String statusType;

}

