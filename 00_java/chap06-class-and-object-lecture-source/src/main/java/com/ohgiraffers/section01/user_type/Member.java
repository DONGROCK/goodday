package com.ohgiraffers.section01.user_type;

public class Member {
    /*지금까지는 우리는 클래스 내부에 메소드만 작성 했다.
    * 클래스 내부에는 메소드를 작성하지 않고 바로 변수를 선언할 수도 있다.
    * 이것을 전역변수 (필드 == 인스턴스변수 == 속성 )라고 부른다.
    * */

    String id;
    String pwd;
    String name;
    int age;
    char gender;
    String[] hobby;


    /*참고*/
//    public void test(){ //메소드선언
//        int i = 0; //변수선언 (지역변수: local variable)
//    }
}
