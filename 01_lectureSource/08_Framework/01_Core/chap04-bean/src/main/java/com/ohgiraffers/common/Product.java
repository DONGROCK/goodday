package com.ohgiraffers.common;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Product {

    private String name;        //상품명
    private int price;          //상품가격
}
