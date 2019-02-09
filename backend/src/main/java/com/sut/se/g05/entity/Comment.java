package com.sut.se.g05.entity;

import lombok.*;

import javax.persistence.*;

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
    private @NonNull String phone;

    private @NonNull String name;

    private String post;

    @ManyToOne
    private Level level1;
    @ManyToOne
    private Level level2;
    @ManyToOne
    private Level level3;
}
