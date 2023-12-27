package com.ohgiraffers.section02.abstractclass;

public abstract class Product {

    private int nonStaticField;
    private static int staticfield;
    /*추상클래스는 생성자도 가질 수 있다.
    * 하지만 직접적으로 인스턴스를 생성할 수는 없다.
    * */
    public Product() {

    }

    /*추상클래스는 일반메소드도 가질 수 있다.*/
    public void nonStaticMethod(){
        System.out.println("Product 클래스의 nonStaticMethod 호출함..");
    }

    public static void staticMethod(){

        System.out.println("Product 클래스의 staticMethod호출함...");
    }

    /*추상메소드
    * 미완성 메소드(추상메소드)를 생성할 수 있다.
    * 추상메소드가 0개인 경우 선택적으로 클래스에 abtract키워드를 작성해야 한다.
    * */

    public abstract void abstMethod();
}
