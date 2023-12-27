package com.ohgiraffers.section02.abstractclass;

public class SmartPhone extends Product{

    /*
    SmartPhone 클래스는 Product클래스를 상속받아서 구현
     *
     * extends키워드로 두개 이상의 클래스를 상속받지 못한다.(모호성제거)
     * 추상클래스가 가지는 추상 메소드를 반드시 오버라이딩 해야한다. (강제성부여)
     * */

    @Override
    public void abstMethod() {

        System.out.println("Product클래스의 abstMethod를 오버라이딩 한 메소드 호출함..");
    }

    public void printSmartPhone(){
        System.out.println("SmartPhone 클래스의 printSmartPhone 메소드 호출함..");
    }
}
