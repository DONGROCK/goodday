package com.ohgiraffers.section01.polymorphism;

public class Application3 {
    public static void main(String[] args) {

        Application3 app3 = new Application3();

        Animal animal1 = new Rabbit(); //다형성 적용
        Animal animal2 = new Tiger(); //

        app3.feed(animal1);
        app3.feed(animal2);

        Rabbit animal3 = new Rabbit();
        Tiger animal4 = new Tiger();

        app3.feed(animal3); //명시적 형변환
        app3.feed(animal4);

        app3.feed(new Rabbit()); //묵시적 형변환
        app3.feed(new Tiger());

    }

    public void feed(Animal animal){

        animal.eat();
    }
}
