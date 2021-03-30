package com.sparta.myblog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    private String username;
    private String password;

    // 어떻게 설정할지 나중에 결정
    private boolean admin = false;
    private String adminToken = "";
}
