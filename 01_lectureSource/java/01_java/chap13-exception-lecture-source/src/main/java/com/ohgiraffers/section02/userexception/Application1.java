package com.ohgiraffers.section02.userexception;

public class Application1 {
    public static void main(String[] args) {

        ExceptionTest et = new ExceptionTest();

        try {
            /*상품 가격보다 가진 돈이 적을 경우*/
            et.checkEnoughMoney(50000, 3000);

            /* 가진 돈을 음수로 입력했을 경우*/
            et.checkEnoughMoney(50000,-50000);

            /*상품가격을 음수로 입력했을 경우*/
            et.checkEnoughMoney(-50000, 50000);


            et.checkEnoughMoney(50000,30000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
