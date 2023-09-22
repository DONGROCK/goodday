package com.ohgiraffers.section05.logical;

public class Application1 {

    /*논리연산자
    * 논리값(true or false)를 취급하는 연산자이다.
    * */
    public static void main(String[] args) {

        System.out.println("true와 true의 논리 and 연산 : " + (true && true));
        System.out.println("true와 true의 논리 and 연산 : " + (true && false));
        System.out.println("true와 true의 논리 and 연산 : " + (false && true));
        System.out.println("true와 true의 논리 and 연산 : " + (false && false));
        System.out.println("");
        System.out.println("true와 true의 논리 or 연산 : " + (true || true));
        System.out.println("true와 true의 논리 or 연산 : " + (true || false));
        System.out.println("true와 true의 논리 or 연산 : " + (false || true));
        System.out.println("true와 true의 논리 or 연산 : " + (false || false));

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;

        System.out.println("a가 b보다 작으면서 c가 d보다 작은지 확인 : " + (a < b && c < d));
        System.out.println("a가 b보다 작으면서 c가 d보다 큰지 확인 : " + (a < b && c > d));
        System.out.println("a가 b보다 크면서 c가 d보다 작은지 확인 : " + (a > b && c < d));
        System.out.println("a가 b보다 크면서 c가 d보다 큰지 확인 : " + (a > b && c > d));

        System.out.println("a가 b보다 작거나 c가 d보다 작은지 확인 : " + (a < b || c < d));
        System.out.println("a가 b보다 작거나 c가 d보다 큰지 확인 : " + (a < b || c > d));
    }
}
