package com.ohgiraffers.section04.use1;

public class FireCar extends Car implements Soundable{


    @Override
    public void go() {
        System.out.println("소방차가 간다!");
    }

    @Override
    public void stop() {
        System.out.println("소방차 멈춘다!");
    }

    @Override
    public void horn() {
        System.out.println("소방차가 나갑니다. 비켜비켜");
    }

}
