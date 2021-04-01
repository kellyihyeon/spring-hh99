package com.sparta.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private String title;
    private String username;
    private String contents;
    // 작성 날짜는?
}
