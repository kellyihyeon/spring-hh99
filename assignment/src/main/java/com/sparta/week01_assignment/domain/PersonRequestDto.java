package com.sparta.week01_assignment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@RequiredArgsConstructor
public class PersonRequestDto {

    private final String name;
    private final String position;

}
