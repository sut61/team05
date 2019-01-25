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

import java.util.Date;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "carry")
public class Carry {
    @Id
    @SequenceGenerator(name="carry_seq",sequenceName="carry_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carry_seq")  
    @Column(name="Carry_ID",unique = true, nullable = false)

    private @NonNull Long carryId;
    private @NonNull Date date;
    private @NonNull String status;
    private @NonNull String carryNumber;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Receiver.class)
    @JoinColumn(name = "Receiver_ID", insertable = true)
    private  Receiver receiverCarry;


	public void setReceiver(Receiver r) {
        this.receiverCarry = r;
	}

	public void setProvince(Province l) {
	}

	public void setPackageId(Package p) {
	}

}

