package com.ohgiraffers.section03.stringbuilder;

public class Application1 {

    public static void main(String[] args) {

        /*
        * String과 StringBuilder 차이점
        *
        * String : 불변
        * StringBuilder : 가변
        *
        *
        * StringBuilder : 쓰레드 동기화 기능을 제공하지 않는다.
        *                 쓰레드 동기화처리를 고려하지 않는 상황에서 StringBuffer보다 성능이 좋다.
        * StringBuffer  : 쓰레드동기화 기능을 제공한다.
        *                 성능면에서는 StringBuilder보다 느리다.
        *
        *
        *
        * String과 StringBuilder
String : 불변이라는 특성을 가지고 있다.
         문자열에 + 연산으로 합치기 하는 경우, 기존 인스턴스를 수정하는 것이 아닌,
         새로운 인스턴스를 반환한다.
         따라서 문자열 변경이 자주 일어나는 경우 성능 면에서 좋지 않다.
         하지만 변하지 않는 문자열을 자주 읽어 들이는 경우에는 오히려 좋은 성능을 기대할 수 있다.
StringBuilder : 가변이라는 특성을 가지고 있다.
                문자열에 append() 메소드를 이용하여 합치기 하는 경우
                기존 인스턴스를 수정하기 때문에 새로운 인스턴스를 생성하지 않는다.
                따라서 잦은 문자열 변경이 일어나는 경우 String보다 성능이 좋다.

단, jdk 1.5 버전에서는 문자열의 + 연산이 StringBuilder의 append()로 컴파일이 된다.
따라서 성능에 큰 차이를 보이지는 않는다.
하지만 반복문에서 문자열의 + 연산을 수행하는 경우 StringBuilder 인스턴스를
반복 루프 시 마다 생성하기 때문에 성능에는 좋지 않은 영향을 준다.

역컴파일 결과 예시
원본코드
---------------------------------------------------
String str1 = "java";
String str2 = "oracle";
String str3 = str1 + str2;
String str4 = "";
for(int i = 0; i < 10; i++) {
    str4 += str1;
}
----------------------------------------------------

JDK 1.4 이하
----------------------------------------------------
String str1 = "java";
String str2 = "oracle";
String str3 = str1 + str2;
String str4 = "";
for(int i = 0; i < 10; i++) {
    str4 = str4 + str1;
}
----------------------------------------------------

JDK 1.5 이상
----------------------------------------------------
String str1 = "java";
String str2 = "oracle";
String str3 = new StringBuilder(str1).append(str2).toString();
String str4 = "";
for(int i = 0; i < 10; i++) {
    str4 = new StringBuilder(str4).append(str1).toString();
}
        * */
        StringBuilder sb = new StringBuilder("java");

        System.out.println("sb = " + sb.toString());

        System.out.println();



    }
}
