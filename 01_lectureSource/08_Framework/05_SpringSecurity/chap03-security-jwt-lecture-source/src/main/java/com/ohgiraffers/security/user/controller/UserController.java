package com.ohgiraffers.security.user.controller;

import com.ohgiraffers.security.user.entity.User;
import com.ohgiraffers.security.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /***
     * 회원가입
     * @param user 사용자 정보를 담은 객체
     * @return
     */
    @PostMapping("/singup")
    public ResponseEntity singup(@RequestBody User user){

        user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        user.setState("Y"); // 기본값 처리

        User value = userRepository.save(user);

        System.out.println("value =================> " + value);

        if(Objects.isNull(value)){

            return ResponseEntity.status(500).body("회원가입 실패");
        } else {
            return ResponseEntity.ok("회원가입 성공");
        }
    }
}
