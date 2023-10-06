package com.ohgiraffers.parameter;

public class RectAngle {

    private double width;
    private double height;

    public RectAngle(double width, double height){

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void calcArea(){
        double area = width * height;

        System.out.println("이 사각형의 넓이는 " + area + "입니다.");
    }

    public void calcRound(){
        double area = (width + height) * 2;
        System.out.println("이 사각형의 둘레는 " + area + "입니다.");
    }
}
