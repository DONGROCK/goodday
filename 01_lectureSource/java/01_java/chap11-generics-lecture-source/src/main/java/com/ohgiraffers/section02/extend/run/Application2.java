package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application2 {
    public static void main(String[] args) {

        /*
        * 와일드카드(WildCard)
        *
        * 제네릭 클래스 타입의 객체를 메소드의 매개변수로 받을 때
        * 그 객체의 타입 변수를 제한할 수 있다.
        * <?> : 제한 없음
        * <? extends Type> : 와일드카드의 상한 제한 (Type과 Type의 후손을 이용해 생성한 인스턴스만 인자로 사용가능)
        * <? super Type> : 와일드카드 하한 제한(Type과 Type의 부모를 이용해 생성한 인스턴스만 인자로 사용가능)
        * */

        WildCardFarm wildCardFarm = new WildCardFarm();

        /*매개변수의 타입 제한이 없는 경우*/
        /*농장 생성 자체가 불가능한 것은 매개변수로 사용할수없다.*/
//        wildCardFarm.anyType(new RabbitFarm<>(new Mammal()));
//        wildCardFarm.anyType(new RabbitFarm<>(new Reptile()));
        wildCardFarm.anyType(new RabbitFarm<>(new Rabbit()));
        wildCardFarm.anyType(new RabbitFarm<>(new Bunny()));
        wildCardFarm.anyType(new RabbitFarm<>(new DrunkenBunny()));

        /*extendsType(RabbitFarm<? extends Bunny> farm)바니부터 드렁큰바니이기에 토끼안돼*/
//        wildCardFarm.extendsType(new RabbitFarm<>(new Rabbit()));
            wildCardFarm.extendsType(new RabbitFarm<>(new Bunny()));
            wildCardFarm.extendsType(new RabbitFarm<>(new DrunkenBunny()));

            wildCardFarm.superType(new RabbitFarm<>(new Bunny()));
            wildCardFarm.superType(new RabbitFarm<>(new Rabbit()));
//            wildCardFarm.superType(new RabbitFarm<DrunkenBunny>(new DrunkenBunny()));

    }
}
