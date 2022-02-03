package com.sparta.spring_prac02.controller;

import com.sparta.spring_prac02.dto.PostRequestDto;
import com.sparta.spring_prac02.model.Post;
import com.sparta.spring_prac02.security.UserDetailsImpl;
import com.sparta.spring_prac02.service.CommentService;
import com.sparta.spring_prac02.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    //글작성 화면으로 이동
    @GetMapping("/post/write")
    public String write(@AuthenticationPrincipal UserDetailsImpl userDetails,Model model){
            model.addAttribute("username", userDetails.getUsername());
        return "write";
    }


    //글작성 post요청
    @PostMapping("/post/postwrite")
    public String postwrite(PostRequestDto requestDto,Model model,@AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("username",userDetails.getUsername());
        if(requestDto.getTitle().equals("")){
            model.addAttribute("error","제목을 입력해주세요");
            model.addAttribute("contents",requestDto.getContents());
            return "write";
        } else if(requestDto.getContents().equals("")){
            model.addAttribute("error","내용을 입력해주세요");
            model.addAttribute("title",requestDto.getTitle());
            return "write";
        }
        postService.savepost(requestDto,userDetails);
        return "redirect:/";
    }

    //게시글 디테일 조회
    @GetMapping("/post/detail/{id}")
    public String postdetail(@PathVariable Long id, Model model,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Post post=postService.getPostdetail(id);
        model.addAttribute("post",post);
        model.addAttribute("commentList",commentService.getComment(id));
        model.addAttribute("username",userDetails.getUsername());
        return "detail";
    }
}
