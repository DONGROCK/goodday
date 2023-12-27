package com.ohgiraffers.section01.polymorphism;

public class Rabbit extends Animal{

    @Override
    public void eat() {
        System.out.println("토끼 풀 먹는다.");
    }

    @Override
    public void run() {
        System.out.println("토끼가 뛴다!");
    }
    @Override
    public void cry(){
        System.out.println("토끼가 꺼이꺼이 운다..");
    }

    public void jump(){
        System.out.println("토끼 점프한다!");
    }
}
