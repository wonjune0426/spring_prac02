package com.sparta.spring_prac02.repository;

import com.sparta.spring_prac02.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPostidOrderByCreatedAtDesc(Long postid);
    @Modifying
    @Query("update Comment c set c.comment = :comment where c.username=:username and c.postid=:postid")
    void updatecomment(String comment,String username,Long postid);

    @Modifying
    @Query("delete from Comment c where c.postid=:postid and c.username=:username")
    void deletecomment(Long postid,String username);
}
