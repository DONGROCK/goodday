package com.ohgiraffers.section01.conditional;
//실행용
public class Application {

    public static void main(String[] args) {
        A_if a = new A_if();

      //  a.testSimpleIfStatment();
       // a.testNestedIfStatment();
       B_ifElse b = new B_ifElse();
      //  b.testSimpleIfElseStatement();
      //  b.testNestedIfElseStatement();

        C_ifElseIf c = new C_ifElseIf();
        //c.testSimpleIfElseIfStatement();
        //c.testNestedIfElseIfStattment();
        D_swich d = new D_swich();
        //d.testSimpleSwitchStatement();
        d.testSwitchVendingMachine();
    }
}
