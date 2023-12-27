package com.ohgiraffers.section04.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubClass extends SuperClass{

//    @Override
//    public void method(){}

//    @Override
//    public void mathod() throws IOException {

    /*부모이 예외처리 클래스보다 상위의 예외로는 후손클래서에서 오버라이딩 할 수 없다.*/
//    @Override
//    public void method() throws Exception {}//에러

    /*부모의 예외처리 클래스보다 더 하위에 있는 예외의 경우에는 오버라이딩 할 수 있다.*/

    @Override
    public void method() throws FileNotFoundException {} // 정상

}
