package com.ohgiraffers.section02.superkeyword;

public class Application {
    public static void main(String[] args) {
        /*
        * super : 자식클래스를 이용해서 객체를 생성할 때 부모 생성자를 호출하여 부모 클래스의 인스턴스도 함께 생성하게 된다.
        *        이때 생성한 부모의 인스턴스 주소를 보관하는 레퍼런스 변수로 자식 클래스 내의 모든 생성자와
        *        메소드 내에서 선언하지 않고도 사용할 수 있는 레퍼런스 변수이다.
        *
        * super() : 부모 생성자를 호출하는 구문으로 인자와 매개변수의 타입, 갯수, 순서가 일치하는 부모의 생성자ㅡㄹ 호출하게 된다.
        *           this()가 해당 클래스 내의 다른 생성자를 호출하는 구문이라면, super()는 부모클래스가 가지는 private생성자를
        *           제외한 나머지 생성자를 호출 할 수 있도록 한 구문이다.
        * */
        Product product1 = new Product();
        System.out.println(product1.getInfomation());

        Product product2 = new Product("s-1234","삼송","갤록시",10000,new java.util.Date());
        System.out.println(product2.getInfomation());
        System.out.println("-------컴퓨터---------");
        Computer computer1 = new Computer();
        System.out.println(computer1.getInfomation()); //부모꺼도 널값, 자식도 널값
        Computer computer2 = new Computer("i5",512,16,"윈도우");
        System.out.println(computer2.getInfomation()); //부모클래스에만 값을 넣음
        Computer computer3 = new Computer("s-1234","삼송","갤록시",10000,new java.util.Date(),"i5",512,16,"윈도우");
        System.out.println(computer3.getInfomation());//부모클래스, 자식클래스 값을 다 넣음

    }
}
