package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_while {

    /*while문 표현식
    * 초기식
    * while(조건식){
    *   조건을 만족하는 경우 수행할 구문(반복할 구문);
    * }
    *
    * 기본 반복문을 이용해서 조금씩 바꿔가며 우선 문법을 익숙해지도록하자
    * 1. 증감식이 없는 경우
    * 2. 조건식이 true인 경우
    * 3. 초기식, 조건식, 증감식이 없는 경우
    * 4. 초기식,
    * 1부터 10까지 1씩 증가시키면서 i값을 출력하는 기본 반복문*/

    public void testSimpleWhileStatement(){

        int i = 1;
        while (i <= 10){
            System.out.println(i);
            i++;
        }
    }
    public void testWhileExample1(){
        /*
        * 입력한 문자열의 인덱스를 이용하여 문자하나씩 출력해보기
        *               0 부터
        * charAt(): 문자열에서 인덱스에 해당하는 문자를 char형으로 반환하는 기능
        * langth(): String클래스의 메소드로 문자열의 길이를 int형으로 반환한다.
        *
        * index는 0부터 시작하고 마지막인덱스는 항상 길이보다 한 개 작은 숫자를 가진다.
        * 만약 존재하지 않은 인덱스에 접근하게되면 StringIndexOfBoundsException이 발생
        * */
        //길이와 인덱스는 1차이가 남.

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();

        System.out.println("======for문======");
        for(int i = 0; i < str.length(); i++){

            char ch = str.charAt(i);
            System.out.println(i + " : " + ch);

        }

        System.out.println("======while======");
        int index = 0;
        while (index < str.length()){
            char ch = str.charAt(index);
            System.out.println(index + " : " + ch);

            index++;
        }
    }

    public void testWhileExample2(){
        /*정수 하나를 입력 받아 1부터 입력받은 정수까지의 합계를 구한다.*/
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt();

        //초기식
        int i = 1;
        //합계를 처리할 변수
        int sum = 0;
        while (i < num){

            sum += i;
            i++;
        }

        System.out.println("1부터 입력 받은 정수 " + num + "까지의 합은 " + sum + "입니다.");
        int sum2 = 0;
        for (int j = 1; j <= num; j++){
            sum2 += j;
            System.out.println("1부터 입력 받은 정수 " + num + "까지의 합은 " + sum2 + "입니다.");
        }
    }

    public void testWhileExample3(){
        /*중첩 while문을 이용한 구구단 출력하기*/
        int dan = 2;
        while (dan < 10){

            int su = 1;
            while (su <10){
                System.out.println(dan + " * " + su + " = " + (dan * su));
                su++;
            }
            System.out.println();
            dan++;
        }
    }
}
