package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {

    /*IS-A관계 확인*/
    private String cpu;
    private int hdd;
    private int ram;
    private String operationSystem;/*운영체제*/

    //매개변수있는 생성자
    /*1. 부모필드의 값은 기본값으로 초기화하고 내꺼만 초기화하는 생성자
     * 2. 부모필드, 내필드 모두 값을 받아서 초기화하는 생성자
     *
     * Computer computer = new Computer();
     * 부모의 기본생성자를 호출해서 객체생성
     * 자기기본생성자 호출해서 객체생성
     * */

    public Computer() {
        System.out.println("컴퓨터 클래스의 기본생성자 호출..");
    }


    public Computer(String cpu, int hdd, int ram, String operationSystem) {
        super();

        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;

        System.out.println("Computer 클래스의 모든 필드를 초기화하는 생성자 호출됨..");
    }

    public Computer(String code, String brand, String name, int price,
                    Date manufacturingDate, String cpu, int hdd, int ram,
                    String operationSystem) {
        super(code, brand, name, price, manufacturingDate);
//        this(cpu, hdd, ram, operationSystem);
        /*위에처럼 하고 싶지만 this()로 위에 작성한 생성자를 호출한다는의미는
         * super()를 두번 호출하는것과 같기 때문에 허용되지않는다.
         *
         * 부모인스턴스를 두개 생성할 수 없기 때문에 부모 생성자는 한번만 호출 가능하다..
         * */
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;

        System.out.println("Computer클래스의 부모필드도 초기화하는 생성자 호출됨..");
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getInfomation() {
     /*   return "code = " + super.getCode()
                + "brand = " + super.getBrand()
                + "name = " + super.getName()
                + "price = " + super.getPrice()
                + "manufacturingDate = " + super.getManufacturingDate()
                + "cpu = " + this.cpu
                + "hdd = " + this.hdd
                + "ram = " + this.ram
                + "operationSystem = " + this.operationSystem;*/

        /*super.getInfomation() 정상적으로 부모의 메소드 호출
        * this.getInfomation() 재귀호출이 일어나며 stackOverFlow 발생
        * getInfomation() this. 이 자동으로 추가되어 재귀호출이 일어난다
        *
        * 그래서 아래의 경우 명시적으로 super을 명시적으로 사용해야한다.*/
        return super.getInfomation() // this. 일시 재귀호출
                + "\ncpu = " + this.cpu
                + "\nhdd = " + this.hdd
                + "\nram = " + this.ram
                + "\noperationSystem = " + this.operationSystem;

    }
}
