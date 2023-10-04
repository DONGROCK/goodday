package com.ohgiraffers.section03.copy;

public class Application2 {
    public static void main(String[] args) {

        /*얕은 복사의 활용
        *
        * 얕은 복사를 활용하는 것은 주로 메소드 호출 시 인자로 사용하는 경우와
        * 리턴값으로 동일한 배열을 리턴해주고 싶은 경우 사용된다.
        * */

        String[] names = {"홍길동", "이순신", "유관순"};

        System.out.println("names 의 hashcode : " + names.hashCode());

        print(names);

        String[] animals = getAnymals();

        System.out.println("리턴받은 animals의 hashcode : " + animals.hashCode());

        System.out.println(animals[0]);

        System.out.println();
    }



    public static void print(String[] sarr) {
        System.out.println("sarr 의 hashcode : " + sarr.hashCode());

        for (int i = 0 ; i < sarr.length; i++){
            System.out.print(sarr[i] + " ");
        }

    }

    public static String[] getAnymals() {
        String[] animals = new String[] {"낙타", "호랑이", "나무늘보"};

        System.out.println("새로만든 anymals의 hashcode : " + animals.hashCode());

        return animals;
    }
}
