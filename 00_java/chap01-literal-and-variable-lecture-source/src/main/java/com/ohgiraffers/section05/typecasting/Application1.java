package com.ohgiraffers.section05.typecasting;

public class Application1 {

        /*
        * 데이터 형변환
        * 데이터 형변환이 필요한 이유
        * - 자바에서 다른 타입끼리의 연산은 피연산자들이 모두 같은 타입인 경우 실행할 수 있다.
        * - 즉, 같은 데이터 타입끼리만 연산을 수행할 수 있다.
        *
        * 형변환의 종류와 규칙
        1. 자동형변환 (묵시적 형변환) : 컴파일러가 자동으로 수행해주는 타입 변환
        1-1. 작은 자료형에서 큰 자료형으로는 자동 형변환 된다.
        1-2. 정수는 실수로 자동 형변환 된다.
        1-3. 문자형은 int형으로 자동 형변환 된다.
        1-4. 논리형은 형변환 규칙에서 제외된다.
        2. 강제형변환 (명시적 형변환) : 형변환(cast) 연산자를 이용한 강제적으로 수행하는 형변환
        2-1. 자동형변환이 적용되지 않는 경우 강제 형변환이 필요하다.
        * */
    public static void main(String[] agrs){
    // 점점 더 큰 자료형으로 데이터를 옮겨도 문제없이 자동형변환 처리가 된다.
        byte bnum = 1;
        short snum = bnum;
        int inum = snum;
        long lnum = snum;

        int num1 = 10;
        long num2 = 20;

        //int result = num1 + num2; 자동으로 큰쪽 자료형인 long으로 변경 후 계산하기때문에 int 형 변수에 값을 담을 수 없다.
        long result1 = num1 + num2;// int + long 은 설 다른 자료형이라 데이터 손실이 발생하지 않는 int -> long 변환을 자동 수행 후 연산

        System.out.println("result1 : " + result1);

        //정수는 실수로 자동 형변환된다.
        //long eight = 8888888888; 이것도 자동으로 형변환이 일어난 상태이며 오류는 int 범위를 벗어나서 에러발생
        long eight = 8;
        float four = eight;

        System.out.println("four : " + four);
        //실수와 정수의 연산은 실수로 연산 결과가 반환된다.
        float result3 = eight + four;
        System.out.println("result3 " + result3);

        //문자형은 int 형으로 자동형변환 된다.

        char ch1 = 'a';
        int charNumber = ch1;

        System.out.println("charNumber : " + charNumber);
        // int로 type이 정해지지 않은 리터럴 형태의 정수는 char형 변수에 기록 가능하다.
        int test = 65;
        char ch2 = 65;
        System.out.println("ch2  :" + ch2);

    }
}
