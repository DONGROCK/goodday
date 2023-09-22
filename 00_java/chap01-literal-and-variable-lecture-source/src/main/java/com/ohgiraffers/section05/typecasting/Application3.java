package com.ohgiraffers.section05.typecasting;

public class Application3 {

    public static void main(String[] args) {

        /*자동형변환과 강제형변환을 이용하여 서로 다른 자료형끼리 연산을 수행
        *
        * 자동형변환과 강제형변환을 이용한 다른 자료형끼리의 연산
        * 다른 자료형 끼리 연산은 큰자료형으로 자동 형변환 후 연산처리된다.
        * */

        int inum =  10;
        long lnum = 100;

        //자바는 같은 자료형끼리만 연산이 가능하다.
        //int inum = inum + lnum;
        int isum = (int)(inum + lnum);// 값을 마지막에 인트로 바꾼다
        System.out.println("isum : " + isum);

        int isum2 = inum +(int) lnum;// 값을 구하기 전 롱을 인트로 바꾼다.

        System.out.println("isum2 : " + isum2);

        long lsum = inum + lnum; // 값을 구하기 전에 공간을 long으로 바꾼다

        System.out.println("lsum : " + lsum);

        // 주의. int 미만의 연산 처리 결과는 int 형이다.
        byte byteNum1 = 1;
        byte byteNum2 = 2;
        short shortNum1 = 3;
        short shortNum2 = 4;

        int result1 = byteNum1 + byteNum2;
        int result2 = byteNum1 + shortNum1;
        int result3 = shortNum1 + byteNum1;
        int result4 = shortNum1 + shortNum2;

        //의도하지 않은 값 손실
        int loseNum = 290;
        byte bnum = (byte) loseNum;

        System.out.println("loseNum : " + loseNum);
        System.out.println("bnum : " + bnum);

        //의도한 데이터 손실
        double height = 185.9;
        int doubleheight = (int) height;

        System.out.println("height : "+ height);
        System.out.println("doubleheight : "+ doubleheight);

    }
}
