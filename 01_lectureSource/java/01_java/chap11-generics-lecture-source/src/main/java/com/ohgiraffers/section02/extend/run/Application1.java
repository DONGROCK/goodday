package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application1 {
    public static void main(String[] args) {

        /*extends 키워드를 이용해서 특정 타이만 사용하도록 제한 건다.*/

        /*RabbitFarm<T extends Rabbit> 선언하면
        * 토끼의 후손이거나 토끼인 경우에만 타입으로 사용 가능하다.
        *
        * Animal타입으로는 제네릭 클래스 인스턴스 생성이 불가능하다.*/
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();

        /*Mammal타입으로는 제네릭 클래스 인스턴스 생성이 불가능하다.*/
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<Mammal>();

        /*전혀 다른 타입을 이용해서도 인스턴스 생성이 불가능*/
//        RabbitFarm<Snake> farm3 = new RabbitFarm<Snake>();

//        토끼의 후손들이고 토끼이기 때문에 가능
        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();

        /*올바른 인자타입을 넣어야한다.*/
//        farm4.setAnimal(new Snake());

        farm4.setAnimal(new Rabbit());
        ((Rabbit) farm4.getAnimal()).cry();
        farm4.getAnimal().cry(); // 형변환 생락 가능

        farm5.setAnimal(new Bunny());
        farm5.getAnimal().cry();

        farm6.setAnimal(new DrunkenBunny());
        farm6.getAnimal().cry();

    }
}
