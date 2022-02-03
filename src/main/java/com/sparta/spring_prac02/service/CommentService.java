package com.sparta.spring_prac02.service;

import com.sparta.spring_prac02.dto.CommentRequestDto;
import com.sparta.spring_prac02.model.Comment;
import com.sparta.spring_prac02.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getComment(Long postid){
        return commentRepository.findAllByPostidOrderByCreatedAtDesc(postid);
    }

    public void saveComment(CommentRequestDto commentRequestDto) {
        Comment comment=new Comment(commentRequestDto.getPostid(),commentRequestDto.getUsername(),commentRequestDto.getComment());
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(CommentRequestDto commentRequestDto) {
        commentRepository.updatecomment(commentRequestDto.getComment(),commentRequestDto.getUsername(),commentRequestDto.getPostid());
    }

    @Transactional
    public void deleteComment(CommentRequestDto commentRequestDto) {
        commentRepository.deletecomment(commentRequestDto.getPostid(),commentRequestDto.getUsername());
    }
}
