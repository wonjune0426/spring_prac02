package com.sparta.spring_prac02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private String email;
}