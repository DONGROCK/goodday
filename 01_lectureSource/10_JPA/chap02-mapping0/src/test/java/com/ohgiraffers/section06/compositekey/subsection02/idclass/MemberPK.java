package com.ohgiraffers.section06.compositekey.subsection02.idclass;

import java.io.Serializable;
import java.util.Objects;

public class MemberPK implements Serializable {// 직렬화 해줘야함

    private int memberNo;
    private String memberId;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
