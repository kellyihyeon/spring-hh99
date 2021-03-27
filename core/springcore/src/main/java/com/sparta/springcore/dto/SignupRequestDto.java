package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;  // 체크하면 true 관리자
    private String adminToken = "";
}