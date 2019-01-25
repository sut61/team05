package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "linked")
public class Linked {
    @Id
    @SequenceGenerator(name="linked_seq",sequenceName="linked_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="linked_seq")  
    @Column(name="Linked_ID",unique = true, nullable = false)
    private @NonNull Long linkedId;                                
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Carry.class)
    @JoinColumn(name = "Carry_ID", insertable = true)
    private  Carry carryLinked;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID", insertable = true)
    private  Province provinceLinked;

    // @Column(name="Province_ID")
    // private Province provinceLinked;


}

