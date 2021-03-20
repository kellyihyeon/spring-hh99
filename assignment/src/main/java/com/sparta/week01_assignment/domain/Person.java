package com.sparta.week01_assignment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String nickName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = true)
    private String hobby;

    @Column(nullable = true)
    private String phone;


    public Person(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Person(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.position = requestDto.getPosition();
    }

    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.position = requestDto.getPosition();
    }
}
