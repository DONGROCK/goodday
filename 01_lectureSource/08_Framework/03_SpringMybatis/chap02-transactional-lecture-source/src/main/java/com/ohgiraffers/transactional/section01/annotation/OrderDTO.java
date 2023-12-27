package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class OrderDTO {
    private LocalDate orderDate;
    private LocalTime orderTime;
    private List<OrderMenuDTO> orderMenus;

}
