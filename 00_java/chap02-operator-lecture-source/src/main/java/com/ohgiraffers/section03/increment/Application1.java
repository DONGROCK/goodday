package com.ohgiraffers.section03.increment;

public class Application1 {

    /*증강연산자에 대한 이해
    *
    * 증강연산자
    * 피연산자 앞 or 뒤에 사용가능
    * '++' : 1증가의 의미
    * '--' : 1감소의 의미
    * */
    public static void main(String[] args) {

        int num = 20;

        num++;//1증가시키기

        System.out.println("num : " + num);

        ++num;
        System.out.println("num : " + num);

        --num;
        System.out.println("num : " + num);
        num--;
        System.out.println("num : " + num);
        //증감연산자를 다른 연산자와 함께 사용
        int firstNum = 20;

        int result1 = firstNum++ * 3; // 다른 연산을 먼저 처리하고 난뒤 마지막에 증가를 한다

        System.out.println("firstNum : " + firstNum);
        System.out.println("result1 : " + result1);

        int second = 20;

        int result2 = ++second * 3; // 다른 연산을 하기전 먼저 처리하고 다른연산을 한다.

        System.out.println("result2 : " + result2);
        System.out.println("second : " + second);

        int num1 = 10;
        int addNum = num1++;

        System.out.println("addNum : " + addNum);
        System.out.println("num1 : " + num1);
        System.out.println("======================");
        int a = 10;
        int b = 20;
        int c = 30;

        System.out.println(a++); // a: 10(11), b = 20, c = 30
        System.out.println((++a) + (b++)); // a : 12 , b = 20(21) , c = 30
        System.out.println((a++) + (--b) + (--c));// a: 12(13), b : 20, c = 29  61
        System.out.println(a +" "+ b +" "+ c);
    }
}
