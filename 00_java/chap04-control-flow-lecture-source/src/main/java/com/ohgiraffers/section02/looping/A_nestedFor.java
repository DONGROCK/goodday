package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_nestedFor {

    /*for 문 안에 for 문을 이용할 수 있따.
    * */
    public void printGugudanFromTwoToNine(){

        //2단부터 단을 1식 증가 시키는 반복문
        for (int dan = 2; dan <= 9; dan++){

            printGugudanOf(dan);
            System.out.println("");

        }
    }
    public void printGugudanOf(int dan){

        for (int su = 1; su <=9; su++){
            System.out.println(dan + "*" + su + " = " +(dan * su));
        }
    }
    public void printStarInputRowTimes(){
        /*키보드로 정수를 하나 입력 받아 해당 정수 만큼 한 행에 "*" 를 5개씩 출력하셔*/
        Scanner sc = new Scanner(System.in);
        System.out.print("출력할 행 수를 입력하셔 : ");
        int row = sc.nextInt();
        /* 행 row */
        /* 열 */

        /*입력한 행만큼 반복*/
        for(int i = 1; i <= row; i++){

            for(int j = 1; j <= 5; j++){

                System.out.print("*");
            }
            System.out.println();
        }

    }
    public void printTrinagleStars(){

        /*키보드로 정수를 입력받아 해당 정수만큼 한 행에 "*"을
        * 행의 번호개씩 출력하세여*/
        System.out.println("출력할 줄 수를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        for (int i = 1;i <= row; i++){

            for(int j = 1; j <= i; j++){

                System.out.print("*");
            }
            System.out.println();
        }
    }
}
