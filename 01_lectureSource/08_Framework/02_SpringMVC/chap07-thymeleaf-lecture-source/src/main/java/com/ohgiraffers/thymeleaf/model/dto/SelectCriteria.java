package com.ohgiraffers.thymeleaf.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SelectCriteria {

    private int startPage;
    private int endPage;
    private int pageNo;
}
