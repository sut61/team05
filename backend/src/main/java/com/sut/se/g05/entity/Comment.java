package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter @Setter
@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Comment {
    @Id
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq")
    @GeneratedValue(generator = "comment_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull @Size(min = 10, max = 10)
    @Pattern(regexp = "^[0]\\d+$")
    @Column (unique = true)
    private String phone;

    @NotNull @Size(min = 3, max = 20)
    @Pattern(regexp = "^[ก-๙a-zA-Z]+$")
    private String name;

    private String post;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Gender.class)
    private Gender gender;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Province.class)
    private Province province;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Level.class)
    private Level level1;
    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Level.class)
    private Level level2;
    @ManyToOne(fetch=FetchType.EAGER, targetEntity = Level.class)
    private Level level3;
}
