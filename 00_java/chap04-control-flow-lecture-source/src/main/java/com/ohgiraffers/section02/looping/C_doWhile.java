package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_doWhile {
    /*doWhile문
    * [do-while문 표현식]
    * 초기식
    * do{
    *   1회차에는 무조건 실행하고, 이후에는 조건식을 확인하여 조건을 만족하는 경우
    *   수행할 구문(반복할 구문);
    *   증감식;
    * } while(조건식);
    *
    * */
    public void testSimpleWhileStatement(){

        do{     /*조건식의 결과와 상관 없이 최초 1번은 무조건 동작함
                    이게 느낌이 그거 노래방 처음에 코인넣으면 화재시 비상구위치 알려주는 그런 거*/
            System.out.println("최초한번 동작함..");
        }while (false);

        System.out.println("반복문 종료 확인.");
    }

    public void testDoWhileExample(){
        /*키보드로 문자열 입력 받아 반복적으로 출력
        *  단, exit가 입력되면 반복문을 종료한다.
        *
        * 이전에 말했던것처럼 문자열의 같은지의 비교는 == 비교는 문자열의 리터럴형식으로 생성된 내용들끼리만
        * 가능하여, 문자열의 값이 같은지는 String클래스에서 제공하는 equals()라는 메소드를 이용해서
        * 비교를 한다. 해당 메소드에 대한 내용은 뒤에서 자세히 다룬답니다.*/

        Scanner sc = new Scanner(System.in);
        String str = "";

        do{
            System.out.println("문자열을 입력하세요 : ");
            str = sc.nextLine();
            System.out.println(str);

        }while(!str.equals("exit"));//!표를 붙이며 exit 외에는 다 트루가 됨 exit가 이제 종료버튼이 되버림.
    }
}
