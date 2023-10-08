package com.ohgiraffers.section01.level02.normal;

import java.util.Scanner;

public class Application5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력해주세요 : ");
        String str = sc.next();

        System.out.println("검색할 문자를 입력해주세요 : ");
        char cha = sc.next().charAt(0);

        char[] carr = str.toCharArray();

        int count = 0;
        String strIndex = "";

        for (int i = 0; i < carr.length; i++){
            if (carr[i] == cha){

                count++;
                strIndex += i + " ";
            }
        }
        System.out.println("입력한 문자열 : " + str );
        System.out.println("찾는 문자 : " + cha);
        System.out.println(cha + " 개수 : " + count);
        System.out.println("application에 i가 존재하는 위치(인덱스) : " + strIndex);
        System.out.println(count + " 개");

        /*
         * 문자열을 입력받아 문자 하나하나를 배열에 넣고 검색할 문자가
         * 문자열에 몇 개 들어가 있는지 개수와 몇 번째 인덱스에 위치하는지
         * 인덱스를 출력하세요.
         *
         * ex.
         *	문자열 : application
         *	문자 : i
         *	application에 i가 존재하는 위치(인덱스) : 4 8
         *	i 개수 : 2
         * */
    }
}
