package com.ohg.security.user.model.service;

import com.ohg.security.auth.model.dto.AuthDetails;
import com.ohg.security.user.model.dao.UserMapper;
import com.ohg.security.user.model.dto.LoginUserDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthServiceImpl implements UserService{


    private final UserMapper userMapper;

    public AuthServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /*
    * 사용자의 id를 입력받아 DB에서 회원을 조회하는 메소드
    * @param username 사용자 id
    * @return AuthDetais: user*/
    @Override
    public AuthDetails findByUserId(String username) {
        LoginUserDTO login = userMapper.findByUsername(username); //사용자 존재여부

        System.out.println("login ----->" + login);

        AuthDetails auth = new AuthDetails(login);

        if(Objects.isNull(auth)){
            throw new UsernameNotFoundException("사용자 정보가 존재하지 않습니다.");
        }
        return auth;
    }
}
