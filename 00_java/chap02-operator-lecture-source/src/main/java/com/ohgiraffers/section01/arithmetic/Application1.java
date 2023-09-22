package com.ohgiraffers.section01.arithmetic;

public class Application1 {


        /*
        * 산술연산자
        * 산술연산자는 주로 사칙연산과 관련된 연산자로 가장 기본적이면서 많이 쓰임
        * 연산의 실행이 가능하기 때문에 필요한 값이나 변수가 두 개인 이항 연산자로 분류되며
        * 피연산자들의 연산 방향은 왼쪽에서 오른쪽이다
        *
        * 산술연산자의 우선순위
        * 수학의 개념과 유사하게 곱셈 나눗셈 연산이 더하기빼기 보다 우선적으로 동작
        * 우선순위가 같은 경우 연산자의 결합 방향에 의해 순서가 결정됨
        *  */
    public static void main(String[] args) {
    int num1 = 20;
    int num2 = 7;
        System.out.println("num1 + num2 : "+ (num1 + num2));
        System.out.println("num1 - num2 : "+ (num1 - num2));
        System.out.println("num1 * num2 : "+ (num1 * num2));
        System.out.println("num1 / num2 : "+ (num1 / num2));
        System.out.println("num1 % num2 : "+ (num1 % num2));


    }
}
