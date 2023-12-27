package com.ohgiraffers.common;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShoppingCart {

    private final List<Product> items;      // 쇼핑카트에 담긴 상품들

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product){
        items.add(product);
    }

}
