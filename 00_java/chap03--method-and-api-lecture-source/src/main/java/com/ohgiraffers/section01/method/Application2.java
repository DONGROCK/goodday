package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args){

        System.out.println("main() 시작됨..");
        Application2 app2 = new Application2();
        app2.methodA();
        app2.methodB();
        app2.methodC();
        System.out.println("main() 애들아 수고했다..");

    }

    public void methodA(){

        System.out.println("methodA() 호출이야..");
        System.out.println("methodA() 퇴근이야..");
    }
    public void methodB(){

        System.out.println("methodB() 호출이야..");
        System.out.println("methodB() 퇴근이야..");
    }
    public void methodC(){

        System.out.println("methodC() 호출이야..");
        System.out.println("methodC() 퇴근이야..");
    }
}
