package com.sut.se.g05.entity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    private Long packid;
    private Date regDate;
    private Timestamp regTime;
    @NotNull
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9_\\-.]+$")
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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Informationemp.class)
    @JoinColumn(name = "infoId")
    @JsonIgnore
    private Informationemp employee;
}
