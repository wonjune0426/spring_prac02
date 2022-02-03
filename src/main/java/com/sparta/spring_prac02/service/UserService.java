package com.sparta.spring_prac02.service;

import com.sparta.spring_prac02.dto.SignupRequestDto;
import com.sparta.spring_prac02.model.User;
import com.sparta.spring_prac02.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public String registerUser(SignupRequestDto requestDto){
        String username=requestDto.getUsername();
        Optional<User> finduser=userRepository.findByUsername(username);
        String error="";
        if(finduser.isPresent()){
            return "중복된 id 입니다.";
        }

        if(username.length()<3){
            return "ID를 3자 이상 입력해주세요";
        }else if(!Pattern.matches("^[a-zA-Z0-9]*$",username)){
            return "ID는 알파벳 대소문자와 숫자로만 입력해주세요";
        }

        if(!requestDto.getPassword().equals(requestDto.getPassword2())){
            return "비밀번호가 일치하지 않습니다.";
        }else if(requestDto.getPassword().contains(username)){
            return "ID가 포함된 비밀번호는 사용할 수 없습니다.";
        }

        if(requestDto.getEmail()==null) {
            return "E-mail을 입력해주세요.";
        } else if(!Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",requestDto.getEmail())){
            return "E-mail 형식에 맞지 않습니다.";
        }

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        User user=new User(username,requestDto.getPassword(),requestDto.getEmail());
        userRepository.save(user);

        return error;
    }
}
