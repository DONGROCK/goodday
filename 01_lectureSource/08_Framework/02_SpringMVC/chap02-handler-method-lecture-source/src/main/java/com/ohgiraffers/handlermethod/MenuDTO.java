package com.ohgiraffers.handlermethod;


import lombok.*;

/*
* DTO를 작성할 때 커멘드객체로 이용하기 위해서는 form의 name값과 일치하게 만들어야 한다.
* */

//커멘드 객체는 기본생성자를 이용하여 인스턴스를 만들기 때문에 기본생성자가 반드시 필요하다.
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MenuDTO {

    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;



}
