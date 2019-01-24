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
@Table (name="Province")
public class Province {

    @Id
    @SequenceGenerator(name = "province_seq", sequenceName = "province_seq")
    @GeneratedValue(generator = "province_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "PROVINCE_ID", unique = true, nullable = true)

    private Long provinceId;
    private @NonNull String province;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
