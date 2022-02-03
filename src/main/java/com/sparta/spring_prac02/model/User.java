package com.sparta.spring_prac02.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Getter
@Entity
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //nullable:null 허용 여부
    //unique: 중복 허용 여부 (false 일때는 중복 허용)
    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private Long kakaoId;

    public User(String username,String password,String email){
        this.username=username;
        this.password=password;
        this.email=email;
        this.kakaoId=null;
    }

    public User(String username,String password,String email,Long kakaoId){
        this.username=username;
        this.password=password;
        this.email=email;
        this.kakaoId=kakaoId;
    }

}
