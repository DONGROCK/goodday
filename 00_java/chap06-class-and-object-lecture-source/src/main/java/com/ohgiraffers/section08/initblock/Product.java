package com.ohgiraffers.section08.initblock;

public class Product {
    /*필드를 초기화 하지 않으면 JVM이 정한 기본값으로 객체가 생성된다.*/
    private String name = "갤럭시";

    private int price = 100000;
    private static String brand = "삼성";

    /*인스턴스 초기화 블럭*/
    {
        name = "사이언";
        price = 900000;

        /*주의사항
        * 인스턴스 초기화 블럭에서는 static 필드로 초기화할 수 있는 것 처럼보인다.
        * 하지만 static 초기화 블럭은 클래스가 로드 될 때 이미 기본값으로 초기화를 진행한다.
        * 따라서 인스턴스 초기화 블럭이 동작하는 시점에서는 이미 초기화가 진행된 정적 필드에
        * 인스턴스 초기화 블럭에서 대입한 값을 덮어 쓰게 되는 것이다.
        * */
        brand = "사과";

        System.out.println("인스턴스 초기화 블럭 동작...");
    }

    static {
        /*static 초기화 블럭에서는 non-static 필드를 초기화하지 못한다*/
        brand = "헬지";
    }
    public Product(){
        System.out.println("기본 생성자 호출됨...");
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        Product.brand = brand;
        System.out.println("매개변수 있는 생성자 호출됨....");
    }

    public String getInfomation(){

        return "name = " + this.name +
                "\nprice = " + this.price +
                "\nbrand = " + Product.brand;
    }
}
