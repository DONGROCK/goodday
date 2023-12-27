package com.ohgiraffers.section02.extend;
                /*
                인터페이스 상속시 implements 키워드를 사용하면 에러발생
                그래서extend를 사용한다.
                 */

//public class RabbitFarm<T implements Animal> { 에러가 난다.
//public class RabbitFarm<T extends Animal> {// 정상.
//public class RabbitFarm<T extends Rabbit> {
//public class RabbitFarm<T extends Rabbit, Reptile> { //클래스를 여러개 붙일 때 , 를 사용
//public class RabbitFarm<T extends Rabbit & Animal> { //오류는 없는 뒤에 작성한 클래스를 또 다른 타입변수로 본다 그래서 인터페이스 상속시 &를 사용

public class RabbitFarm<T extends Rabbit> {
    private T animal;

    public RabbitFarm() {
    }

    public RabbitFarm(T animal){
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}
