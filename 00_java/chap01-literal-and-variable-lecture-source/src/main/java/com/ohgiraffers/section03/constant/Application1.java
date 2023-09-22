package com.ohgiraffers.section03.constant;

public class Application1 {
        /*
        변수란 시간에 따라 변하는 값을 담는 공간
        상수는 처음에 한번 들어가면 그 이후부터는 변경이 안되는 공간
        상수는 예를 들어 원주율, 그런 고정된 값을 사용할 때
        상수란?
        *
        * 변수가 메모리에 변경될 값을 지정하기 위한 공간을 나타낸다면,상수는 이와  상반되는 개념이다.
        * 변하지 않는 값을(항상 고정된 값을) 지정해두기 위한 메모리상의 공간을 상수 라고한다.
        *
        * 상수의 목적
        * 변경되지 않는 고정된 값을 지정할 목적으로 사용한다.
        * 초기화 이후 값 대입 시 컴파일 에러를 발생시켜 값이 수정되지 못하도록한다.
        * */

    public static void main(String[] args){
    /*상수 선언*/
    /*상수 선언 시 자료형 앞에 final 키워드를 붙인다.
        상수 선언 시에는 대문자로 구분가능하게 하는 것이 좋음.
    * 메소드, 클래스에도 사용 가능*/
        final int AGE;
        AGE = 20;
        //AGE = 30; 한번 초기화 한 이후 값을 재 대입하는 것은 불가
        System.out.println("AGE의 값 : "+ AGE);
        System.out.println("");
        System.out.println("AGE의 2배 : " + (AGE * 2));
        int sum = AGE;
        //AGE = AGE + 10; 대입연산자를 기준으로 왼쪽은 공간 오른쪽은 값 이기 때문에
        //                  기술이 불가능

    }
}
