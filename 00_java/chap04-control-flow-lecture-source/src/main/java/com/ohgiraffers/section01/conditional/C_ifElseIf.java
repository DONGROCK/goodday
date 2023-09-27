package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class C_ifElseIf {
    /*if -> 1개 참 일때만 실행
    * if else -> 1개 참일때 실행할 내용/ 거짓일 때 실행*/

    /*[if- else-if문 표현식]
    *
    * if(조건식1){
    *   조건식1이 true일 때 실행할 명령문;
    * } else if(조건식2){
    *   조건식1이 false이고 조건식2가 true일 때 실행할 명령문;
    * } else{
    *   위의 조건 2개가 모두 거짓인 경우 실행할 명령문;
    *   }
    *
    * if-else-if문은 조건식 1의 결과값이 참(true)이면 if{} 안에 있는 코드를 실행하고,
    * 조건식1이 flase이면 조건식2를 확인하여 참(true)이면 else if{} 안에 있는 코드를 실행한다.
    * 조건식1,2의 결과값이 모드 거짓(false)이면 else{} 안에 있는 코드를 실행한다.
    *
    * */

    public void testSimpleIfElseIfStatement(){
        System.out.println("산 속에서 나무를 하던 나무꾼이 연못에 도끼를 빠뜨리고 말았다..");
        System.out.println("연못에서 산신령이 나타나 금도끼, 은도끼, 쇠도끼를 들고 나타났다.");
        System.out.println("산신령이 나무꾼에게 셋 중 어떤 도끼가 나무꾼의 도끼인지 물어봤다.");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("어느도끼가 너의 도끼니?(1. 금도끼, 2. 은도끼, 3.쇠도끼)");
        int answer = sc.nextInt();

        System.out.println("answer = " + answer);

        /*금도끼인지, 은도끼인지, 쇠도끼인지 검증*/
        if (answer == 1){

            System.out.println("그짓말 금도끼는 내꺼다");
        } else if (answer == 2){

            System.out.println("그짓말허지마 은도끼는 내꺼다.");
        } else {

            System.out.println("정직하구나 다 너 가져가라");
        }

        System.out.println("산신령은 연못으로 다시 사라졌다.");
    }

    public void testNestedIfElseIfStattment(){
        /*
         *  ohgiraffers 대학의 유xx교수님은 학생들 시험 성적을 수기로 계산해서 학점 등급을 매기는 채점방식을 사용하고 있었다.
         *  90점 이상이면 'A', 80점 이상이면 'B', 70점 이상이면 'C', 60점 이상이면 'D'를
         *  60점 미만인 경우에는 'F'를 학점 등급으로하는 기준이다.
         *  추가로 각 등급의 중간점수(95, 85, 75..)인 경우 '+'를 붙여서 등급을 세분화 하다보니 신경쓸게 이만 저만이 아니다.
         *  그래서 학생의 이름과 점수를 입력하면 자동으로 학점 등급이 계산되는 프로그램을 만들기로 했다.
         * */
        Scanner sc = new Scanner(System.in);
        System.out.println("학생의 이름을 입력하세요.");
        String name = sc.nextLine();

        System.out.println("학생의 점수를 입력하세요.");
        int point = sc.nextInt();

        /*학생의 등급을 저장하기 위한 변수 초기화*/
        String grade = "";

        if(point >= 90){

            grade = "A";

            if (point >= 95){
                grade += "+";
            }
        } else if (point >= 80) {

            grade = "B";

            if (point >= 85){
                grade += "+";
            }
        } else if (point >= 70) {

            grade = "C";

            if (point >= 75){
                grade += "+";
            }
        } else if (point >= 60) {

            grade = "D";

            if (point >= 65){
                grade += "+";
            }
        } else {

            grade = "F";

        }

        System.out.println(name + " 학생의 점수는 " + point + "이고, 등급은 " + grade + "입니다.");
        System.out.println("프로그램 종료됩니다..");
    }
}
