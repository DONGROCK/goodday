package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args){
        System.out.println("hi");
        System.out.print("안녕하세요");
        System.out.println(123);

        //여러가지 값의 형태를 출력하기
        //1숫자형태의 값
        /* 1. 숫자 형태의 값
            정수 형태의 값 출력
         */
        System.out.println(54321);
        //실수 형태의 값 출력
        System.out.println(1.234);
        //문자 형태의 값 출력
        System.out.println('A');
        //System.out.println('');  아무것도 기록되지 않는경우 에러
        //System.out.println('1'); 그냥 1이라는 껍대기를 가진 문자 ''사이에 있는 숫자는 그냥 문자이다.
        //문자열 형태의 값 출력
        System.out.println("Hi");
        System.out.println("123"); // 쌍따옴표안에 123은 숫자가 아니고 문자열이다.
        System.out.println(""); // 아무것도 없는 빈 쌍따옴표도 문자열 취급 가능
        System.out.println("a"); // 문자와 문자열은 다르다 생김새가 같더라도.
        System.out.println(true);
        System.out.println(false);
    }
}
