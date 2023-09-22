package com.ohgiraffers.section05.typecasting;

public class Application2 {

        /*강제형변환
        * 바꾸려는 자료형으로 캐스트연산자를 이용하여 형변환한다
        * 예0 (바꿀자료형) 값;*/

        /*
        *자동형변환 규칙의 반대 상황에서 강제 형변환이 필요하다.
        * 1. 강제형변환 규칙
        * 1-1. 큰 자료형에서 작은 자료형으로 변경시 강제 형변환이 필요하다.
        * 1-2. 실수를 정수로 변경 시 강제 형변환이 필요하다.
        * 1-3. 문자형은 int미만 크기의 변수에 저장할 때 강제 형변환이 필요하다
        * 1-4. 논리형은 강제 형변환 규칙에서도 제외된다 */

    public static void main(String[] args) {

        long lnum = 8;
        //int inum = lnum; // 데이터 손실 가능성을 컴파일러 알려주는 것
        int inum = (int) lnum; //변경하려는 자료형을 명시하여 강제 형변환을 해야한다.

        short snum = (short) inum;
        byte bnum = (byte) snum;

        double dnum = 8.0;
        float fnum = (float) dnum;

        float fnum2 = 4.0f;
        //long lnum2 = fnum2; float는 4byte, long은 8byte임에도 자동형변환 블가능(소수점 자리 이하 데이터 손실 가능성)
        long lnum2 = (long) fnum2;

        char ch = 'a';

        byte bnum2 = (byte) ch;
        short snum2 = (byte) ch;
        // 정수를 char자료형에 강제로 형변환해서 대입하기
        int num1 = 97;
        int num2 = -97;

        char ch2 = (char) num1;
        char ch3 = (char) num2;

        System.out.println("ch2 : " + ch2);
        System.out.println("ch3 : " + ch3);

        boolean isTrue = true;

        //byte b = (byte) isTrue;
    }
}
