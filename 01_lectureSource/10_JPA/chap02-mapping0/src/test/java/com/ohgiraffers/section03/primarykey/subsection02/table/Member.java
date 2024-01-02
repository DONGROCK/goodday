package com.ohgiraffers.section03.primarykey.subsection02.table;
import jakarta.persistence.*;

import java.util.Date;
/* 컬럼 매핑 시 @Column 어노테이션에 사용 가능한 속성들
 * 1. name : 매핑할 테이블의 컬럼 이름
 * 2. insertable : 엔티티 저장 시 필드 저장 여부 (default : true)
 * 3. updatable : 엔티티 수정 시 필드 수정 여부 (default : true)
 * 4. table : 엔티티와 매핑될 테이블 이름. 하나의 엔티티를 두 개 이상의 테이블에 매핑할 때 사용. (@SecondaryTable 사용)//사용비추
 * 5. nullable : null값 허용 여부 설정. not null 제약조건에 해당함 (true 기본값)
 * 6. unique : 컬럼의 유일성 제약 조건
 * (두 개 이상 컬럼에 unique 제약조건을 설정하기 위해서는 클래스 레벨에서 @Table의 uniqueConstraints 속성에 설정)
 * 7. columnDefinition : 직접 컬럼의 DDL을 지정
 * 8. length : 문자열 길이. String 타입에서만 사용. (default : 255)
 * */


@Entity(name = "member_section03_subsection02")
@Table(name = "tbl_member_section03_subsection02")
@TableGenerator(
        name = "member_seq_table_generator", //기본키의 이름
        table = "tbl_my_sequences",
        pkColumnName = "my_seq_member_no"
)
public class Member {

        @Id
        @Column(name="member_no")
        @GeneratedValue(strategy = GenerationType.TABLE, //오토인크리먼트가 없는 테이블
                generator = "member_seq_table_generator")
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

        @Column(name="address", nullable = false) //(nullable = false)null  불가능 하다. 작성안할시 nullable = true 기본값
        private String address;

        @Column(name="enroll_date")
//        @Temporal(TemporalType.TIMESTAMP) //dateTime과 똑같
//        @Temporal(TemporalType.DATE) // date
        @Temporal(TemporalType.TIME) //time
        private Date enrollDate;

        @Column(name="member_role")
        private String memberRole;

        @Column(name="status", length = 3) //varchar 3 문자형 데이터길이 설정시에 사용된다 length
        private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickname, String phone, String email, String address, Date enrollDate, String memberRole, String status) {
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
                ", memberRole='" + memberRole + '\'' +
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

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
