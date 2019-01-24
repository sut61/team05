package com.sut.se.g05.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table (name="Receiver")
public class Receiver {

    @Id
    @SequenceGenerator(name="receiver_seq",sequenceName="receiver_seq")
    @GeneratedValue(generator="receiver_seq",strategy=GenerationType.SEQUENCE)
    @Column(name="RECEIVER_ID",unique = true, nullable = true)

    private Long receiverId;
    private @NonNull String receiver;
    private @NonNull String firstnamerec;
    private @NonNull String lastnamerec;
    private @NonNull String addressrec;
    private @NonNull String postcoderec;
    private @NonNull String phonerec;


    //Many To One with Province
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "RPId")
    @JsonIgnore
    private Province province;

    //Many To One with Link
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Link.class)
    @JoinColumn(name = "RLId")
    @JsonIgnore
    private Link link;

    public Receiver(String receiver, String firstnamerec, String lastnamerec, String addressrec, String postcoderec, String phonerec, Province province, Link link) {
        this.receiver = receiver;
        this.firstnamerec = firstnamerec;
        this.lastnamerec = lastnamerec;
        this.addressrec = addressrec;
        this.postcoderec = postcoderec;
        this.phonerec = phonerec;
        this.province = province;
        this.link = link;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getFirstnamerec() {
        return firstnamerec;
    }

    public void setFirstnamerec(String firstnamerec) {
        this.firstnamerec = firstnamerec;
    }

    public String getLastnamerec() {
        return lastnamerec;
    }

    public void setLastnamerec(String lastnamerec) {
        this.lastnamerec = lastnamerec;
    }

    public String getAddressrec() {
        return addressrec;
    }

    public void setAddressrec(String addressrec) {
        this.addressrec = addressrec;
    }

    public String getPostcoderec() {
        return postcoderec;
    }

    public void setPostcoderec(String postcoderec) {
        this.postcoderec = postcoderec;
    }

    public String getPhonerec() {
        return phonerec;
    }

    public void setPhonerec(String phonerec) {
        this.phonerec = phonerec;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
