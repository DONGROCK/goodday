package com.ohgiraffers.section06.singleton;

public class LazySingleton {

    /*클래스가 초기화 되는 시점에서는 정적 필드를 선언해두고 null로 초기화된다.*/
    private static LazySingleton lazy;

    /*외부에서 인스턴스를 생성하는 것을 제한*/
    private  LazySingleton(){}

    public static LazySingleton getInstance(){

        if(lazy == null){
            lazy = new LazySingleton();
        }

        return lazy;
    }
}
