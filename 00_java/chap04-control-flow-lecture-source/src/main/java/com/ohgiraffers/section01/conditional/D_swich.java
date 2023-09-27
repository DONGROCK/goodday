package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_swich {

    /*
    *
    * [swich문 표현식]
    *
    * swich(비교할변수){
    *   case 비교값1 : 비교값1과 일치하는 경우 실행할 구문; brack;
    *   case 비교값2 : 비교값2와 일치하는 경우 실행할 구문; brack;
    *   default + case에 모두 해당하지 않는 경우 실행할 구문; brack;
    * }
    *
    * 여러 개의 비교값 중 일치하는 조건에 해당하는 로직을 실행하는 것은 if-else-if와 유사하다.
    * 따라서 일부 호환이 가능하다,
    * 하지만, switch문으로 비교 가능한 값은 정수, 문자, 문자열 형태의 값이다.
    * 실수와 논리는 비교할 수 없다.
    * 또한 정확하게 일치하는 경우에만 비교할 수 있으며 대소비교를 할 수 없다는게 차이점이다.
    * case 절에서 변수를 사용하지 못한다(값만 비교 가능)
    * 또한, 문자열 비교는 jdk1.7 이상부터 가능하니 사용하는 버전에 따라서 사용해야한다.
    *
    * */

    public void testSimpleSwitchStatement(){

        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 정수 입력 : ");
        int first = sc.nextInt();
        System.out.println("두번째 정수 입력 : ");
        int second = sc.nextInt();
        System.out.println("연산 기호 입력(+, -, *, /, %) : ");
        char op = sc.next().charAt(0);

        /*연산의 결과를 저장할 변수*/
        int result = 0;

        switch (op){
            case '+' :
                result = first + second;
                break;
            case '-' :
                result = first - second;
                break;
            case '*' :
                result = first * second;
                break;
            case '/' :
                result = first / second;
                break;
            case '%' :
                result = first % second;
                break;

                /*default문은 생략 가능하지만 생략하는 경우 주석으로 생략 이유를 간단하게 작성해주는 것이 좋다.
                * 산술연산 외에 다른 문자에 대한 처리는 생략하려고 default문을 작성안함
                * */


        }
        System.out.println(first + " " + op + " " + second + " = " + result);
    }

    public void testSwitchVendingMachine(){

        /*
        * 1. JDK 1.7 이상부터 switch문을 이용하여 문자열을 비교할 수 있다.
        * 2. break를 사용하지 않으면 멈추지 않고 계속 실행구문을 동작시킨다.
        * */

        Scanner sc = new Scanner(System.in);

        System.out.println("== Ohgiraffers vending machine ==");
        System.out.println("  사이다  콜라  환타  박카스  핫식스  ");
        System.out.println("=================================");
        System.out.println("음료를 선택해주세요 : ");

        String selectedDrink = sc.nextLine();

        /*원하는 음료에 맞는 가격을 저장할 변수*/
        int price = 0;

        switch (selectedDrink){
            case "사이다" :
                System.out.println("사이다를 선택하셧습니다.");
                price = 500;
            case "콜라" :
                System.out.println("콜라를 선택하셨습니다.");
                price = 600;
            case "환타" :
                System.out.println("환타를 선택하셨습니다.");
                price = 700;
            case "박카스" :
                System.out.println("박카스를 선택하셨습니다.");
                price = 700;
            case "핫식스" :
                System.out.println("핫식스를 선택하셨습니다.");
                price = 10000;
        }

        System.out.println(price + "원을 투입해주세요.");

        System.out.println("개선된자판기");

        String order = "";

        switch (selectedDrink){
            case "사이다" :
                order = "사이다";
                price = 500;
                break;
            case "콜라" :
                order = "콜라";
                price = 600;
                break;
            case "환타" :
                order = "환타";
                price = 700;
                break;
            case "박카스" :
                order = "박카스";
                price = 700;
                break;
            case "핫식스" :
                order = "핫식스";
                price = 10000;
                break;
        }
        System.out.println(order + " 을 선택하셨습니다.");
        System.out.println(price + " 원을 투입해주세요.");
    }
}
