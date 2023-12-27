package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
* 호출에 따른 프록시에서 처리할 메소드를 구현하기 위해 InvocationHandler를 구현
* */
public class Handler implements InvocationHandler {

//    public Handler(Student student) {
//        this.student = student;
//    }



    //메소드 호출을 위해 타겟 인스턴스가 필요하다.
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("공부하자..");
        System.out.println("호출 대상 메서드 : " + method);
        for (Object arg: args){
            System.out.println("전달된 인자 : " + arg);
        }
        /*
        * 타겟 메소드를 호출하게 되고, 타겟 Object와 인자를 매개 변수로 전달한다.
        *
        * */
        method.invoke(student, args);

        System.out.println("공부를 마치고 수면학습을 시작한다..");

        return proxy;
    }
}
