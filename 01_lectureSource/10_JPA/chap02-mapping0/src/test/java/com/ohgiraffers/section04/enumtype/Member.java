package com.ohgiraffers.section04.enumtype;
import jakarta.persistence.*;

import java.util.Date;
/*
* @Enumerated 어노테이션은 Enum 타입 매핑을 위해서 사용
* */
@Entity(name = "member_section04")
@Table(name = "tbl_member_section04")
//@TableGenerator(
//        name = "member_seq_table_generator",
//        table = "tbl_my_sequences",
//        pkColumnName = "my_seq_member_no"
//)
public class Member {

        @Id
        @Column(name="member_no")
//        @GeneratedValue(strategy = GenerationType.TABLE,
//                generator = "member_seq_table_generator") //mysql 이라 auto 아이덴티티나 똑같다
        private int memberNo;

        @Column(name="member_id")
        private String memberId;

        @Column(name="member_pwd")
        private String memberPwd;

        @Column(name="nickname")
//        @Transient      //테이블 생성할 때 무시된다.
        private String nickname;

        @Column(name="phone", columnDefinition = "varchar(200) default '010-0000-0000'") //기본값설정 및 자료형
        private String phone;

        //unique = true 중복값이 들어갈수 없게 중복값이 들어갈 시
        // 데이터베이스는 오류를 반환하고 삽입을 거부합니다.
        @Column(name="email", unique = true)
        private String email;

        @Column(name="address", nullable = false) //(nullable = false)null 불가능 하다. 작성안할시 nullable = true 기본값
        private String address;

        @Column(name="enroll_date")
        private Date enrollDate;

        @Column(name="member_role")
        @Enumerated(EnumType.ORDINAL) // enum으로 타입을 맞춰줘야 한다. String 일시 오류 @Enumerated' but its type 'java.lang.String' is not an enum
        private RoleType memberRole;

        @Column(name="status", length = 3) //varchar 3 문자형 데이터길이 설정시에 사용된다 length
        private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickname, String phone, String email, String address, Date enrollDate, RoleType memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole=" + memberRole +
                ", status='" + status + '\'' +
                '}';
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

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public RoleType getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(RoleType memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
