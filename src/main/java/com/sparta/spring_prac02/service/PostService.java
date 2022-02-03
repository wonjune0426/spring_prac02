package com.sparta.spring_prac02.service;

import com.sparta.spring_prac02.dto.PostRequestDto;
import com.sparta.spring_prac02.model.Post;
import com.sparta.spring_prac02.repository.PostRepository;
import com.sparta.spring_prac02.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public void savepost(PostRequestDto requestDto, UserDetailsImpl userDetails){
        Post post=new Post(requestDto.getTitle(),userDetails.getUser().getUsername(),requestDto.getContents());
        postRepository.save(post);
    }

    public List<Post> getPostlist() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public Post getPostdetail(Long id) {
        return postRepository.getById(id);
    }
}
