package com.ohgiraffers.section01.literal;

public class Application2 {

    public static void main(String[] args){
/*
        숫자와 숫자의 연산
        정수와 정수의 연산
 */
         /* 나머지를 구하는 연산을 사용 할 수 있다.*/
        System.out.println("========정수와 정수의 연산 =========");
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10); // *은 곱하기
        System.out.println(123 / 10); // /는 나누기 몫을 반환
        System.out.println(123 % 10); // %는 나누기 후 나머지
        System.out.println("");
        System.out.println("========정수와 실수의 연산 =========");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 1.0);
        System.out.println("");
        System.out.println("========정수와 실수의 연산 =========");
        /*
        정수와 실수의 연산은 사칙연산 및 나머지 연산이 가능하다.
        정수의 실수의 연산의 결과는 항상 실수가 나온다. 중요함.
         */
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 + 1.0);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);
        System.out.println("");
        System.out.println("========문자와 문자의 연산 =========");
        /*문자의 연산*/
        System.out.println('a'+'b');
        System.out.println('a'-'b');
        System.out.println('a'*'b');
        System.out.println('a'/'b');
        System.out.println('a'%'b');
        System.out.println("");
        System.out.println("========문자와 정수의 연산 =========");
        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 1);
        System.out.println('a' / 1);
        System.out.println('a' % 1);
        System.out.println("");
        System.out.println("========문자와 실수의 연산 =========");
        System.out.println('a' + 1.0);
        System.out.println('a' - 1.0);
        System.out.println('a' * 1.0);
        System.out.println('a' / 1.0);
        System.out.println('a' % 1.0);
        System.out.println("");

        /*
        문자열의 연산은 '+' 연산만 가능하다.
        다른 연산은 사용하지 못한다.
         */
        System.out.println("========문자열과 문자열의 연산 =========");
        System.out.println("hello " + "world");
        /*
        System.out.println("hello " - "world");
        System.out.println("hello " * "world");
        System.out.println("hello " / "world");
        System.out.println("hello " % "world");
        */
        System.out.println("========문자열과 다른형태의 연산 =========");
        System.out.println("hello"+123);
        System.out.println("hello"+123.456);
        System.out.println("hello"+'ㅁ');
        System.out.println("hello"+true);
            //문자열과 다른형태의 연산의 값은 문자열이 된다.
            // 이어붙여주는 형태가 된다.

        /*논리값 연산*/
        /* 논리값 끼리의 연산은 모든 연산자 사용이 불가능 하다.
        /* 논리값과 실수, 정수, 문자 연산은 모든 연산자 사용이 불가능 하다.
            문자도 결국 숫자로 취급되기 때문
        System.out.println(true + true);
        System.out.println(true + 1);
        System.out.println(true + 'A');
        System.out.println(true + 0.1);
        */
        //논리값과 문자열의 연산은 '+' 만 연산 가능
        //문자열 합치기가 되는 원리와 동일
        System.out.println(true + "문자열");
    }
}
