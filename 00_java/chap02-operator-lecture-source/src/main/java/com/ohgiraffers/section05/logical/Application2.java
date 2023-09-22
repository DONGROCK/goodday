package com.ohgiraffers.section05.logical;

public class Application2 {

    /*논리 연산자의 우선순위 활용
    * && : 11 순위
    * || : 12 순위*/

    /*1부터 100 사이의 값인지 확인
    *
    * 1 <= 변수 <= 100 이렇게 사용 불가
    * i >= 1 && i <= 100*/
    public static void main(String[] args){
        int num1 = 50;
        System.out.println("1부터 100 사이인지 확인 : " + (num1 >= 1 && num1<= 100));

        int num2 = 150;
        System.out.println("1부터 100 사이인지 확인 : " + (num2 >= 1 && num2<= 100));

        /*영어 대문자니?
        * 문자변수 >= 'A' && 문자변수 <= 'Z'
        * */
        char ch1 = 'G';
        System.out.println("ch1이 대문자 인지 확인 : " + (ch1 >= 'A' && ch1 <= 'Z'));
        char ch2 = 'g';
        System.out.println("ch1이 대문자 인지 확인 : " + (ch2 >= 'A' && ch2 <= 'Z'));

        /*대소문자 상관없이 영문자 y인지 확인*/
        char ch3 = 'Y';
        System.out.println("대소문자 상관없이 영문자 y 인지 확인 : " +(ch3 == 'y' || ch3 =='Y'));
        char ch4 = 'y';
        System.out.println("대소문자 상관없이 영문자 y 인지 확인 : " +(ch4 == 'y' || ch4 =='Y'));
        char ch5 = 't';
        System.out.println("영문자 인지 확인 " + ((ch5 >= 'a' && ch5 <= 'z') || (ch5 >= 'A' && ch5 <= 'Z')));
    }
}
