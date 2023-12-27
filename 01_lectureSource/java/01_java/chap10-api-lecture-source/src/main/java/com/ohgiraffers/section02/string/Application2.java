package com.ohgiraffers.section02.string;

public class Application2 {
    public static void main(String[] args) {

        /*
        * 문자열 객체를 만드는 방법
        * "" 리터럴 형태 : 동일한 값을 가지는 인스턴스를 단일 인스턴스로 관리한다.(singleton)
        * new String("문자열") : 매번 새로운 인스턴스를 생성한다.
        * */

        String str1 = "java";
        String str2 = "java";
        String str3 = new String("java");
        String str4 = new String("java");

        System.out.println("str1 == str2 : " + (str1 == str2));
        System.out.println("str2 == str3 : " + (str2 == str3));

        System.out.println("str3 == str4 : " + (str3 == str4));

        System.out.println("str1 의 hashcode() : " +str1.hashCode());
        System.out.println("str2 의 hashcode() : " +str2.hashCode());
        System.out.println("str3 의 hashcode() : " +str3.hashCode());
        System.out.println("str4 의 hashcode() : " +str4.hashCode());

        System.out.println("str1.equals(str3) : " + str1.equals(str3));
        System.out.println("str1.equals(str4) : " + str1.equals(str4));
        /*
        *문자열은 불변이라는 특징을 가진다.
        * */
        str2 += "oracle";
        System.out.println("str1 == str2 : " + (str1 == str2));

        /*Scanner - > 문자열을 입력받으면 == 비교는 안되고, equals() 비교 해야한다.
        *
        * 입력받은 값을 substring으로 잘라내기해서 새로운 문자열 생성 후 반환해서
        * new String()으로 인스턴스를 생성한 것과 동일한것으로 볼수 있다. 그래서 equals를 사용해서 비교해야 했다.
        *
        * */
    }
}
