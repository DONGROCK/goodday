package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal{

    @Override
    public void eat() {
        System.out.println("호랑이 고기 먹는다.");
    }

    @Override
    public void run() {
        System.out.println("호랑이는 잘 안뛴다. 어슬렁어슬렁 걸어간다.");
    }

    @Override
    public void cry() {
        System.out.println("호랑이도 가끔 눈물을 흘린다..");
    }

    public void bite(){
        System.out.println("호랑이가 앙 물어뜯는다.");
    }
}
