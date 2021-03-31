package com.grit.springsecurity.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
public class Account {


    @Id
//    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)   // IDENTITY = 디비에 위임
    private Long id;

    private String username;
    private String password;
    private String email;
    private String age;
    private String role;


    @Builder
    public Account(Long id, String username, String password, String email, String age, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.role = role;

    }


}
