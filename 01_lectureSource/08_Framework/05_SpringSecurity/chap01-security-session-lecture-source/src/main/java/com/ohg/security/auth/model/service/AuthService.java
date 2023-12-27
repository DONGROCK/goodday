package com.ohg.security.auth.model.service;

import com.ohg.security.user.model.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
* security에서 사용자의 아이디를 인증하기 위한 interface이다
* loadUserByUsername를 필수도 구현해야 하며 로그인 인증 시 해당 메서드에
* login 요청 시 전달된 사용자의 id를 매개변수로 db에서 조회를 한다.
* */
@Service
public class AuthService implements UserDetailsService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findByUserId(username);
    }
}
