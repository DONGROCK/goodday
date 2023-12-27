package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderMenu {

    private int orderCode;
    private int menuCode;
    private int orderAmount;


    public OrderMenu() {
    }

    public OrderMenu(int menuCode, int orderAmount) {
        this.menuCode = menuCode;
        this.orderAmount = orderAmount;
    }
}
