package com.ohgiraffers.section01.init;

public class Application {

    public static void main(String[] args) {

        /*
        * 객체배열은 레퍼런스변수에 대한 배열이다.
        * 생성한 인스턴스도 배열을 이용해서 관리하면
        * 통일한 타입의 여러 개 인스턴스를 각각 취급하지 않고 연속 처리할 수 있어서 유용하다.
        * 또한 반환값은 1개의 값만 반환할 수 있기 때문에
        * 통일한 타입의 여러 인스턴스를 변환해야 하는 경우 객체배열을 이용할 수 있다.
        * */

        Car car1 = new Car("페라리", 300);
        Car car2 = new Car("람보르기니", 350);
        Car car3 = new Car("유모차", 20);
        Car car4 = new Car("따릉이", 430);
        Car car5 = new Car("두돈반", 700);

        car1.driveMaxSpeed();
        car2.driveMaxSpeed();
        car3.driveMaxSpeed();
        car4.driveMaxSpeed();
        car5.driveMaxSpeed();

        Car[] carArray = new Car[5];

        carArray[0] = new Car("페라리", 300);
        carArray[1] = new Car("람보르기니", 350);
        carArray[2] = new Car("유모차", 20);
        carArray[3] = new Car("따릉이", 430);
        carArray[4] = new Car("두돈반", 700);

        for (int i = 0; i < carArray.length; i++){
            carArray[i].driveMaxSpeed();
        }

        Car[] carArray2 = { // 배열 선언 동시에 값을 넣는것과 동일
                new Car("페라리", 300),
                new Car("람보르기니", 350),
                new Car("유모차", 20),
                new Car("따릉이", 430),
                new Car("두돈반", 700)
        };

        /*향상된 for문도 사용가능*/
        for (Car c : carArray2){
            c.driveMaxSpeed();
        }

    }
}
