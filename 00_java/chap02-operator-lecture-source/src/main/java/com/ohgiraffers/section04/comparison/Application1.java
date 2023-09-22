package com.ohgiraffers.section04.comparison;

public class Application1 {

    /*
    *비교연산자
    * 비교연산자는 피연산자 사이에서 상대적인 크기를 판단하며 참 혹은 거짓을 반환하는 연산자
    * 연산자 중 참 혹은 거짓을 반환하는 연산자는 삼항연산자의 조건식이나 조건문의 조건절에 많이 사용
    * */

    /*
     *  비교연산자의 종류
     *  '==' : 왼쪽의 피연산자와 오른쪽의 피연산자가 같으면 true 다르면 false를 반환
     *  '!=' : 왼쪽의 피연산자와 오른쪽의 피연산자가 다르면 true 같으면 false를 반환
     *  '>'  : 왼쪽의 피연산자가 오른쪽의 피연산자보다 크면 true 아니면 false를 반환
     *  '>=' : 왼쪽의 피연산자가 오른쪽의 피연산자보다 크거나 같으면 true 아니면 false를 반환
     *  '<'  : 왼쪽의 피연산자가 오른쪽의 피연산자보다 작으면 true 아니면 false를 반환
     *  '<=' : 왼쪽의 피연산자가 오른쪽의 피연산자보다 작거나 같으면 true 아니면 false를 반환
     * */
    public static void main(String[] args) {

        int inum1 = 10;
        int inum2 = 20;

        System.out.println("=======정수값 비교=======");
        System.out.println("inum1 과 inum2 가 같은지 비교 : " + (inum1 == inum2));
        System.out.println("inum1 과 inum2 가 같지않은지 비교 : " + (inum1 != inum2));
        System.out.println("inum1 이 inum2 보다 큰지 비교 : " + (inum1 > inum2));
        System.out.println("inum1 이 inum2 보다 크거나 같은지 비교 : " + (inum1 >= inum2));
        System.out.println("inum1 이 inum2 보다 작은지 비교 : " + (inum1 < inum2));
        System.out.println("inum1 이 inum2 보다 작거나 같은지 비교 : " + (inum1 <= inum2));

        /*실수 비교*/
        double dnum1 = 10.0;
        double dnum2 = 20.0;

        System.out.println("==== 실수값 비교 ====");
        System.out.println("dnum1 과 dnum2가 같은지 비교 : " + (dnum1 == dnum2));
        System.out.println("dnum1 과 dnum2가 같지 않은지 비교 : " + (dnum1 != dnum2));
        System.out.println("dnum1 이 dnum2 보다 큰지 비교 : " + (dnum1 > dnum2));
        System.out.println("dnum1 이 dnum2 보다 크거나 같은지 비교 : " + (dnum1 >= dnum2));
        System.out.println("dnum1 이 dnum2 보다 작은지 비교 : " + (dnum1 < dnum2));
        System.out.println("dnum1 이 dnum2 보다 작거나 같은지 비교 : " + (dnum1 <= dnum2));

        /*문자값 비교*/

        char ch1 = 'a';
        char ch2 = 'A';
        System.out.println("char1 과 char2가 같은지 비교 : " + (ch1 == ch2));
        System.out.println("char1 과 char2가 같지 않은지 비교 : " + (ch1 != ch2));
        System.out.println("char1 이 char2보다 큰지 비교 : " + (ch1 > ch2));
        System.out.println("char1 이 char2보다 크거나 같은지 비교 : " + (ch1 >= ch2));
        System.out.println("char1 이 char2보다 작은지 비교 : " + (ch1 < ch2));
        System.out.println("char1 이 char2보다 작은거나 같은지 비교 : " + (ch1 <+ ch2));

        /*논리값 비교
        *  == 와 !=는 비교가능하지만 대쇼비교는 불가능하다
        * */
        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println("====논리값 비교====");
        System.out.println("bool1과 bool2가 같은지 비교 : " + (bool1 == bool2));
        System.out.println("bool1과 bool2가 같지 않은지 비교 : " + (bool1 != bool2));

        /*문자열값 비교
        * 문자열도 ==과 !=은 비교 가능하지만 대소 비교는 불가능하다.
        *
        * 근데.. 아래의 예시와 같을 때만 원하는 값을 찾을 수 있다.
        * 그건 문자열 파트때 알려드린다함.*/
        String str1 = "java";
        String str2 = "java";

        System.out.println("----문자열 비교----");
        System.out.println("str1과 str2가 같은지 비교 : " + (str1 == str2));
        System.out.println("str1과 str2가 같지 않은지 비교 : " + (str1 != str2));

        int x = 10;
        int y = 11;

        boolean result = x <= y;
        System.out.println("result의 값은 : " + result);
    }
}
