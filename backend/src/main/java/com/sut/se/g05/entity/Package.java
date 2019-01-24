package com.sut.se.g05.entity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Package")
public class Package {
    @Id
    @SequenceGenerator(name="pack_seq",sequenceName="pack_seq")
    @GeneratedValue(generator="pack_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="PACKAGE_ID",unique = true, nullable = true)
    private long packid;
    private Date regDate;
    private Timestamp regTime;
    private String supply;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PPId")
    @JsonIgnore
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Sender.class)
    @JoinColumn(name = "SId")
    @JsonIgnore
    private Sender sender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Receiver.class)
    @JoinColumn(name = "RId")
    @JsonIgnore
    private Receiver receiver;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EId")
    @JsonIgnore
    private Employee employee;
}
