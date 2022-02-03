package com.sparta.spring_prac02.controller;

import com.sparta.spring_prac02.dto.CommentRequestDto;
import com.sparta.spring_prac02.security.UserDetailsImpl;
import com.sparta.spring_prac02.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment/write")
    public String commentWrite(@RequestBody CommentRequestDto commentRequestDto){
        commentService.saveComment(commentRequestDto);
        return "redirect:/";
    }

    @PostMapping("/comment/update")
    public String commentupdate(@RequestBody CommentRequestDto commentRequestDto){
        commentService.updateComment(commentRequestDto);
        return "redirect:/";
    }

    @PostMapping("/comment/delete")
    public String commentdelete(@RequestBody CommentRequestDto commentRequestDto){
        commentService.deleteComment(commentRequestDto);
        return "redirect:/";
    }
}
