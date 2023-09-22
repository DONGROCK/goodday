package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args){

        //목표. 변수를 선언하고 할당해서 사옹할 수 있다.
        /*변수를 사용하는 방법
        1. 변수를 준비한다(선언)
        2. 변수에 값을 대입한다(값 대입 및 초기화)
        3. 변수를 사용한다.

        자료형이란
        다양한 형태별로 어느정도 크기를 하나의 값으로 취급할 것 인지
        미리 compiler와 약속한 키워드

        기본자료형(Primary type)과
        참조자료형(Reference type)으로 나뉜다.


        정수를 취급하는 자료형은 4가지가 있다. */

        byte bnum;  // 1byte  자료형타입 변수명
        short snum; // 2byte
        int inum;   // 4byte
        long lnum;  // 8byte

        // 실수를 취급하는 자료형 2가지
        float fnum; // 4byte
        double dnum;// 8byte

        // 문자를 취급하는 자료형은 한가지가 있다.
        char ch;    // 2byte
        char ch2;

        // 논리값을 취급하는 자료형은 한가지
        boolean isTrue; // 1byte

        // 이상의 8가지를 기본자료형이라고함

        String str; // 참조자료형
        /*
        참조자료형은 정해진 크기는 없지만 엄밀히 말하면
        주소값을 다루기 때문에 대량 4byte정도로 생각하면된다
        */

        //변수에 값을 대입하기(값 대입 및 초기화)

        bnum = 1;
        snum = 2;
        inum = 4;   // 기본값
        lnum = 8L;   // long타입이다. 아무 문제 없는 것 같지만 long이기 때문에 뒤에 l 또는 L을 붙여야 한다.
        // 소문자 l 을 써도 되지만 글꼴에 따라 숫자 1과 혼선을 빛을 수 있어 대문자 권장

        // fnum = 4.0;  실수형태의 값을 fnum에 사용하는 것은 불가능
        //대입연산자를 기준으로 왼쪽과 오른쪽은 동일한 자료형 타입이어야한다.
        fnum = 4.0f; //f를 넣지 않으면 컴파일러가 더블로 인식
        dnum = 8.0;

        /*문자를 취급하는 자료형에 값 대입*/
        ch = 'a'; //문자형태의 값을 저장할 수 있음
        ch2 = 97; //'a'는 97이라는 숫자였다 그래서 숫자로도 저장할 수 있다

        isTrue = true;
        isTrue = false; // true 혹은 false 중 한가지의 값만 사용 가능하다.

        str = "안녕문자열";

        int point = 100;
        int bonus = 10;

        System.out.println("==변수에 저장된 값 출력==");
        System.out.println("포인트와 보너스의 합은? " + (point + bonus)+ " 입니다.");

        /*
        * 정리
        * 대입연산자(=)을 기준으로 왼쪽과 오른쪽의 자료형이 같아야 한다
        * 대입연산자의 왼쪽을 공간을 의미하고, 오른쪽의 값을 의미한다.
        * */





    }
}
