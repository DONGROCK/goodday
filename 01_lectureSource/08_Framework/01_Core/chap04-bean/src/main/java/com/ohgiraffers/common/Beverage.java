package com.ohgiraffers.common;


import lombok.*;

//@AllArgsConstructor

//@ToString
@Getter
@Setter
public class Beverage extends Product {

    private int capacity;   //용량

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
