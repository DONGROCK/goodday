package com.ohgiraffers.common;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCart {

    private final List<Product> items;   //쇼핑카드에 담긴 상품들

    public ShoppingCart(){

        items = new ArrayList<>();
    }

    public void addItem(Product product){

        items.add(product);
    }
}
