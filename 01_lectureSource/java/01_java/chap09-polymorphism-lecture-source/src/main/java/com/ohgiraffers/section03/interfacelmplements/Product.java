package com.ohgiraffers.section03.interfacelmplements;

import java.io.Serializable;

public class Product extends Object implements InterProduct, Serializable {
    @Override
    public void nonStaticMethod() {

    }

    @Override
    public void abstMethod() {

    }
    /*클래스에서 인터페이스를 상속받을 때에는 implements 키워드를 사용한다.
    * 또한 인터페이스는 여러 개를 상속받을 수 있으며,
    * extends로 다른 클래스를 상속받는 경우에도 그것과 별개로 인터페이스도
    * 추가 상속이 가능해진다
    * 단, extends 키워드를 앞에 작성하고 implements를 뒤에 작성한다
    * (순서가 바뀌면 에러 발생.)*/

    /*static 메소드는 오버라이딩 할 수 없다.*/
//    @Override
//    public static void staticMethod(){}

    /*default 메소드는 인터페이스에서만 작성 가능하다*/
//    @Override
//    public default void defaultMethod(){}
}

//@Override
//public void defaultMethod(){
//
//    System.out.println("Product클래스의 defaultMathod 호출됨..");
//}