package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

//기능용
public class A_if {

/*if문 단독 사용에 대한 흐름
* [if문 표현식]
* if(조건식){
*   조건식이 true일 때 실행할 명령문;
* }
*
* 조건식 : true or false 가 나오는 연산식을 조건식이라고 한다.
*
* if문은 조건식의 결과값이 참(true)이면 {} 안에 있는 코드를 실행하고,
* 조건식의 결과 값이 거짓(false)이면 {} 안에 있는 코드를 무시하고 넘어간다.
* */
    public void testSimpleIfStatment(){
        /*정수 한 개를 입력 받아 그 수가 짝수이면 "입력하신 숫자는 짝수입니다" 라고
        * 출력하고, 짝수가 아니면 출력하지 않는 구문을작성해보자
        * 단, 조건과 상관없이 프로그램이 종료될 때 "프로그램을 종료합니다" 라고
        * 출력되도록한다.
        * */


        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 하나를 입력해주세요 :");
        int num1 = sc.nextInt();
        //정수를 입력 받는 코드

        // 입력받은 값이 짝수인지 체크하는 조건문
        if(num1 %2 == 0){
            System.out.println("입력하신 숫자는 짝수입니다.");
        }

        //조건문과 상관없이 프로그램 종료를 확인하기 위한 용도의 출력 구문
        System.out.println("프로그램을 종료합니다.");

    }

    public void testNestedIfStatment(){

        /*중첩된 if문 실행 흐름 확인
        * -> if문 안에서 또 다른 조건을 사용하여 uf문을 사용할 수 있다.
        *
        * 정수 한개를 입력 받아 그 수가 양수인 경우에만 짝수인지를 확인하고
        * 짝수이면 "입력하신 숫자는 양수이면서 짝수입니다." 라고 출력하고
        * 둘 중 하나라도 해당하지 않으면 아무 내용도 출력하지 않는 구문을 작성해보자
        * 단, 조건과 상관없이 프로그램이 종료될 때 "프로그램을 종료합니다" 라고 출력되도록 한다.
        * */

        //정수 한개를 입력 받아
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int num = sc.nextInt();
        // 그 수가 양수인 경우에만 짝수인지 확인
        if(num > 0) {
            if (num % 2 == 0) {

                System.out.println("입력하신 숫자는 양수이면서 짝수입니다.");

            }
        }
        System.out.println("프로그램을 종료합니다.");
        // 짝수면 "입력하신 숫자는 양수이면서 짝수입니다." 출력

    }
}
