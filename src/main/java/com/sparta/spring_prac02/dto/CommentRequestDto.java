package com.sparta.spring_prac02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CommentRequestDto {
    private String username;
    private Long postid;
    private String comment;

}
