package com.ohgiraffers.section04.enumtype;

/*
* Enum(Enumerated type)이란, 서로 연관된 상수들의 집합을 의미하는 데이터 타입이다.
* Java에서는 enum키워드를 사용하여 Enum타입을 정의한다.
* Enum 타입을 사용하면 코드의 가독성을 높일수 있으며, 타입 세이프티(type safety)를 보장할 수 있다.
* */
public enum RoleType {

    //문자열로 가져다가 쓸수도 있고,
    // 순서로 가져다가 쓸수 있다. 0 = ADMIN, 1 = MEMBER // 비추
    ADMIN, MEMBER

}
