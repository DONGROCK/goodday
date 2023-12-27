package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    /**
     * 멤버 전제 조회
     * @return 멤버리스트
     */
    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }

    /**
     *
     * @param id
     * @return
     */
    public MemberDTO selectMember(Long id){
        System.out.println("selectMember 메소드 실행");
        return memberDAO.selectMember(id);
    }
}
