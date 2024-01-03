package com.ohgiraffers.section06.compositekey.subsection01.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
//getter, setter, tostring, equals hashCode, 생성자, 매개변수생성자 생성
@Embeddable //임베드 될 수 있는 복합 키 타입을 지정할 때 사용하는 어노테이션
public class MemberPK implements Serializable {//복합키 //직렬화를 하는 이유?
    @Column(name = "member_no")
    private int memberNo;
    @Column(name = "member_id")
    private String MemberId;


    // equals 와 hashCode 생성
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberPK memberPK = (MemberPK) o;
        return memberNo == memberPK.memberNo && Objects.equals(MemberId, memberPK.MemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, MemberId);
    }

    //getter, setter 생성
    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", MemberId='" + MemberId + '\'' +
                '}';
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        MemberId = memberId;
    }

    public MemberPK() {
    }
}
