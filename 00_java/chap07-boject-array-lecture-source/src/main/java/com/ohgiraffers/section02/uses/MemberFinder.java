package com.ohgiraffers.section02.uses;

public class MemberFinder {//회원 전체조회

    public Member[] findAllMembers(){

        return MemberRepository.findAllMembers();
    }
}
