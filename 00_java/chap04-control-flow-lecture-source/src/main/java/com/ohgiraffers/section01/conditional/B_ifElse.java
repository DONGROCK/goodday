package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {

    /*
    * [if-else문 표현식]
    * if(조건식){
    * 조건식이 true일 때 실행할 명령문;
    *
    * }else{
    * 조건식이 false일 때 실행할 명령문;
    * }
    *
    * if 문은 조건식의 결과 값이 참(true)이면 if{}안에 있는 코드를 실행
    * 조건식의 결과 값이 거짓(false)이면 else{} 안에 있는 코드를 실행한다.
    *
    * */

    public void testSimpleIfElseStatement(){
        /*정수 한 개를 입력 받아 그 수가 홀수 이면 "입력하신 숫자는 홀수입니다." 라고 출력하고,
        * 홀수가 아니면 "입력하신 숫자는 짝수입니다." 라고 출력하는 프로그램 작성
        * 단, 조건과 상관없이 프로그램이 종료되면 "프로그램 종료" 출력*/
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력 해주세요 : ");
        int num1 = sc.nextInt();
        if(num1 % 2 != 0){
            System.out.println("입력하신 숫자는 홀수 입니다.");
        }else{
            System.out.println("입력하신 숫자는 짝수 입니다.");
        }
        System.out.println("프로그램 종료..");
    }

    public void testNestedIfElseStatement(){
        /*중첩 if-else 문 실행 흐름 확인
        * if-else 문 안에서 또 다른 조건을 사용하여 if-else 문 사용가능
        * */

        /*
        * 숫자를 하나 입력 받아 양수이면 "입력하신 숫자는 양수입니다." 출력하고,
        * 음수이면 " 입력하신 숫자는 음수입니다." 출력
        * 단, 0이면 "0입니다" 라고 출력
        * "조건상관없이 프로그램종료시 "프로그램종료.. " 출력*/

    //숫자를 하나 입력받아
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세용 : ");
        int num = sc.nextInt();
        //0이면 "0입니다" 출력
        if(num != 0){

         if (num > 0){
             System.out.println("입력하신 숫자는 양수입니다.");
         }  else{
             System.out.println("입력하신 숫자는 음수입니다.");
         }
        }else{
            System.out.println("0입니다");
        }
        System.out.println("프로그램을 종료..");
        //양수이면 "입력하신 숫자는 양수입니다." 출력

        //음수이면 "입력하신 숫자는 음수입니다." 출력
    }
}
