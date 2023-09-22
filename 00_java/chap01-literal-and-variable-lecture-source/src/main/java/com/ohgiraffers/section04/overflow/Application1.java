package com.ohgiraffers.section04.overflow;

public class Application1 {
    public static void main(String[] args){
        /*
        * 자료형 별 값의 최대 범위를 벗어나는 경우
        * 발생한 carry를 버림처리하고 sign bit를 반전시켜 최소값으로 순환시킨다
        *
        * */
        byte num1 = 127;

        System.out.println("num1; " + num1);

        num1++; //++ 1씩 증가

        System.out.println("num1 overflow : " + num1);

        /*언더플로우
        * 오버플로우와 반대개념으로 최소범위보다 작은수를 발생시키는 경우 발생하는 현상
        * */

        byte num2 = -128;

        System.out.println("num2 : " + num2);

        num2--; //-- 1씩 감소

        System.out.println("num2 underflow : " + num2);

        int firstNum = 1000000; //100만
        int secondNum = 700000; //70만

        int multi = firstNum * secondNum;
        System.out.println("firstNum + secondNum : " + multi);

        // 오버플로우를 예측하고 더 큰 자료형으로 결과값을 받아서 처리한다.
        long longMulti = firstNum * secondNum;
        System.out.println("longMulti : " + longMulti);

        // 계산이 처리 되기 전에 long 타입으로 자료형을 변경해주어야한다. (강제형변환이용)
        long result = (long) firstNum * secondNum;
        System.out.println("result : " + result);
    }
}
