package com.ohg.security.user.model.service;

import com.ohg.security.user.model.dao.UserMapper;
import com.ohg.security.user.model.dto.SingUpDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

private UserMapper userMapper;
private PasswordEncoder encoder;

    public MemberService(UserMapper userMapper, PasswordEncoder encoder) {
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    public int regist(SingUpDTO singUpDTO){

        /*
        * 사용자가 처음에 회원가입을 한 값은 일반적인 평문으로 넘겨받게 되는데
        * 평문을 그대로 데이터베이스 쌓으면 보안상에 문제가 생길뿐더러 spring security에서
        * 디코딩하는 과정에서 문제가 생기기 떄문에 회원가입을 할 때 passwordEncoder객체를
        * 이용해서 암호화처리를 해서 사용자를 추가한다.
        * */

        singUpDTO.setUserPass(encoder.encode(singUpDTO.getUserPass()));
        int result = userMapper.regist(singUpDTO);

        return result;
    }
}
