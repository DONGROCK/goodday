package com.ohgiraffers.section02.uses;

import java.util.Scanner;

//서비스 (비즈니스 로직) 메소드들의 묶음
public class MemberService {

    public void signUpMembers(){
//        Scanner sc = new Scanner(System.in);
        /*받아야할 값 넘버 아이디 비번 이름 등등 을 입력받고
        * 넣어준다 맴버 배열에.*/
        Member[] members = new Member[5]; //생성
        members[0] = new Member(1,"user01","pass01","홍길동",20,'남');
        members[1] = new Member(2,"user02","pass02","홍길일",21,'남');
        members[2] = new Member(3,"user03","pass03","홍길이",22,'남');
        members[3] = new Member(4,"user04","pass04","홍길삼",23,'남');
        members[4] = new Member(5,"user05","pass05","홍길사",24,'남');

        MemberRegister memberRegister = new MemberRegister(); //등록
        memberRegister.regist(members);
                            //members 객체배열 주소값
    }

    public void showAllMembers() {
        MemberFinder finder = new MemberFinder();
        System.out.println("===가입된 회원목록===");
        for (Member member : finder.findAllMembers()){

            if (member != null){
                System.out.println(member.getInformation());
            }
        }
        System.out.println("==============");
    }
}
