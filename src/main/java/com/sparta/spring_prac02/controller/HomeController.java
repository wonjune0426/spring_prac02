package com.sparta.spring_prac02.controller;


import com.sparta.spring_prac02.model.Comment;
import com.sparta.spring_prac02.model.Post;
import com.sparta.spring_prac02.repository.PostRepository;
import com.sparta.spring_prac02.security.UserDetailsImpl;
import com.sparta.spring_prac02.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PostService postService;
    @GetMapping("/")
    public String home(Model model,@AuthenticationPrincipal UserDetailsImpl userDetails){
        if(userDetails!=null){
            model.addAttribute("username",userDetails.getUsername());
        }
        List<Post> postList=postService.getPostlist();
        model.addAttribute("postlist",postList);
        return "index";
    }

}
