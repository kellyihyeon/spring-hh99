package com.sparta.myblog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    private String username;
    private String password;

    // 관리자는 없고, 유저 or 방문객으로
    private boolean admin = false;
    private String adminToken = "";
}
