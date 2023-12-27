package com.ohgiraffers.section03.interfacelmplements;

public interface InterProduct extends java.io.Serializable/*, java.util.Comparator*/ {
    /*                                //임포트하거나 다적어서 넣거나

    * 인터페이스가 인터페이스를 상속 받을 시에는 extends 키워드를 사용하며
    * 이때는 여러 인스페이스를 다중 상속 받을 수 있다.
    * */

    /*인터페이스는 상수 필드만 작성이 가능하다.
    *
    * public static final 제어조 조합을 상수필드라고한다.
    * 반드시 선언과 동시에 초기화 해줘야한다.
    * */

    public static final int MAX_NUM = 100; //상수필드

    int MIN_NUM = 10;//일반 변수처럼 생겼지만 상수필드다 이건 묵시적으로  public static final 인것.

    //인터페이스는 생성자를 가질수 없어요
//    public InterProduct(){} 알트인서트해도 안뜸

    /*인터페이스는 구현부가 있는 non-static 메소드를 가질 수 없다.*/
//    public void nonStaticMethod()

    /*추상 메소드만 작성이 가능*/
    public abstract void nonStaticMethod();
    void abstMethod();

    /*static 메소드는 작성이 가능하다. (JDK1.8 추가된 기능)*/
    public static void staticMetghod(){
        System.out.println("InterProduct 클래스의 staticMethod 호츌됨..");
    }
    /*default를 사용하면 non-static 메소드도 작성 가능하다(JDK1.8 추가된 기능)*/
    public default void defaultMethod(){
        System.out.println("InterProduct 클래스의 defaultMethod 호출됨..");
    }


}
