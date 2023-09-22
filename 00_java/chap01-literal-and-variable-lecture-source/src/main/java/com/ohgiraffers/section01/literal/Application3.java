package com.ohgiraffers.section01.literal;

public class Application3 {
    public static void main(String[] args) {
        System.out.println("===  두 개의 문자열 합치기  ===");
        System.out.println(9 + 9); //숫자 18
        System.out.println("9" + 9);// 문자열 99 라고해야 맞는 표현 숫자가 아님
        System.out.println(9 + "9"); //위와 같음 문자열 99
        System.out.println("9" + "9"); //위와 같음 문자열 99
        System.out.println("");
        System.out.println("===  3 개의 문자열 합치기  ===");
        System.out.println(9 + 9 + "9"); //문자열 189
        System.out.println("9" + 9 + 9); //문자열 999
        System.out.println(9 + "9" + 9); // 문자열 999

        /*위에 것을 하나씩 풀어보면 숫자 9 와 문자열 9의 더하기이다
            그 값은 문자열 99 이며 숫자 9 와 또 더하기를 하면
            문자열 999가 된다.
            결과 값을 문자열로 받고 싶을 때
            가장 왼쪽에 ""를 넣어주면 문자열로 값을 받을 수 있다.
         */
        //'+' 연산의 빙향은 왼쪽에서 오른쪽으로 한다.
        System.out.println("9" + (9 + 9));
        //괄호와 사칙연산을 잘 활용 하자.
        System.out.println("=== 10 과 20의 사칙연산 ===");
        System.out.println(10 + 20);
        System.out.println(10 - 20);
        System.out.println(10 * 20);
        System.out.println(10 / 20);
        System.out.println(10 % 20);

        System.out.println("=== 10 과 20의 사칙연산 결과 보기 좋게 출력 ===");
        System.out.println("10 + 20 = " + (10 + 20));
        System.out.println("10 - 20 = " + (10 - 20));
        System.out.println("10 * 20 = " + (10 * 20));
        System.out.println("10 / 20 = " + (10 / 20));
        System.out.println("10 % 20 = " + (10 % 20));
    }
}
