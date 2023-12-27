package com.ohgiraffers.common;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Bread extends Product {

    private Date bakedDate;         // 생산 시간

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "bakedDate=" + bakedDate +
                "} " + super.toString();
    }
}
