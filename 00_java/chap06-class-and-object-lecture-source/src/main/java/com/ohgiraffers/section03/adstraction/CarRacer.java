package com.ohgiraffers.section03.adstraction;

public class CarRacer {

    private final Car car = new Car();



    public void startUp(){

        car.startUp();

    }

    public void stepAccelator(){

        car.go();
    }

    public void stepBreak(){

        car.stop();
    }

    public void trunOff(){

        car.turnOff();
    }
}
