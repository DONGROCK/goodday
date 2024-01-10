package com.ohgiraffers.springdatajpa.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PagingButtonInfo { // 페이징 처리에 관한
    private int currentPage;
    private int startPage;
    private int endPage;

}
