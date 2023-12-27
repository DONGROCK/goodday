package com.ohgiraffers.thymeleafspringboot.member.model.service;

import com.ohgiraffers.thymeleafspringboot.member.model.dao.MemberMapper;
import com.ohgiraffers.thymeleafspringboot.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService implements UserDetailsService {

    private final MemberMapper mapper;

    public AuthenticationService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        log.info("");
        log.info("");
        log.info("[AuthenticationService] ===================================================== start");
        log.info("[AuthenticationService] memberId : " + memberId);

        MemberDTO member = mapper.findByMemberId(memberId);

        log.info("[AuthenticationService] member : " + member);

        if(member == null){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }
        log.info("[AuthenticationService] ===================================================== end");
        return member;
    }

}
