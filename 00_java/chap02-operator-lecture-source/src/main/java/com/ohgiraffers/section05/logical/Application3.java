package com.ohgiraffers.section05.logical;

public class Application3 {
    /*
     * AND 연산과 OR 연산의 특징
     * 논리식 && 논리식 : 앞의 결과가 false이면 뒤를 실행 안함
     * 논리식 || 논리식 : 앞의 결과가 true이면 뒤를 실행 안함
     * */

    public static void main(String[] args){
        int num1 = 10;

        //삼항 연산자 : (조건식)? 조건식의 결과가 참일 때 : 조건식의 결과가 거짓일 때
        int result1 = (false && ++num1 > 0)? num1 : num1;
        System.out.println("&& 실행확인: " + result1);

        int num2 = 10;

        int result2 = (true || ++num2 > 0)? num2 : num2;

        System.out.println("||실행확인 : " + result2);

    }
}
