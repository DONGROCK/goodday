package com.ohgiraffers.section03.interfacelmplements;

public class Application {
    public static void main(String[] args) {

        /*
        * 인터페이스(interface)
        * 여기서 다루게 되는 인터페이스는 자바의 클래스아 유사한 형태이지만
        * 추상메소드와 상수필드만 가질 수 있는 클래스의 변형체를 의미
        *
        * 인터페이스 사용목적
        * 1. 추상클래스와 비슷하게 필요한 기능을 공동화해서 강제성을 부여할 목적으로 사용한다.(표준화)
        * 2. 자바의 단일상속의 단점을 극복할 수 있다.(다중상속)
        *
        * 인터페이스가 정말 많은 의미로 사용된다.
        * 인터페이스 말고 클래스에 작성한 public method또한 객체들이 상호작용을 하기 위한 통로의 의미로
        * 인터페이스라고 불린다.
        * */

        /*인터페이스는 인스턴스를 생성하지 못한다, 그리고 생성자 자체가 존재하지 않는다.*/
//        InterProduct interProduct = new InterProduct();
        InterProduct interProduct = new Product(); //다형성

        interProduct.nonStaticMethod();
        interProduct.abstMethod();

        /*오버라이딩 하지 않으면 인터페이스의 default 메소드로 호출함*/
        interProduct.defaultMethod();

        /*static메소드는 인터페이스명.메소드명(); 호출*/
        InterProduct.staticMetghod();

        /*상수 필드 접근 인터페이스명.필드명 으로접근*/
        System.out.println(InterProduct.MAX_NUM);
        System.out.println(InterProduct.MIN_NUM);

    }
}
