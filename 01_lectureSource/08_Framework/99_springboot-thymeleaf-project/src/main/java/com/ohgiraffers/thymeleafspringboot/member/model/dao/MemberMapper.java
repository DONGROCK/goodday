package com.ohgiraffers.thymeleafspringboot.member.model.dao;

import com.ohgiraffers.thymeleafspringboot.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
    String selectMemberById(String memberId);

    int insertMember(MemberDTO member);

    String selectEncryptedPwd(MemberDTO member);

    MemberDTO selectMember(MemberDTO member);

    MemberDTO findByMemberId(String memberId);

    int updateMember(MemberDTO member);

    int deleteMember(MemberDTO member);
}
