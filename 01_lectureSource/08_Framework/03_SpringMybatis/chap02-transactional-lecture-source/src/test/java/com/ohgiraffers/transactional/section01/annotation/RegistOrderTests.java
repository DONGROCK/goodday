package com.ohgiraffers.transactional.section01.annotation;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class RegistOrderTests {

    @Autowired
    private RegistOrderService registOrderService;

    private static Stream<Arguments> getOrderInfo(){

        OrderDTO orderInfo = new OrderDTO();
        orderInfo.setOrderDate(LocalDate.now());
        orderInfo.setOrderTime(LocalTime.now());

        orderInfo.setOrderMenus(
                List.of(
                        new OrderMenuDTO(1, 10),
                        new OrderMenuDTO(2, 10)
                )
        );
        return Stream.of(Arguments.of(orderInfo));
    }

    @Test
    @DisplayName("주문 등록 테슷흐")
    @ParameterizedTest
    @MethodSource("getOrderInfo")
    void testRegistNewOrder(OrderDTO orderInfo){

        Assertions.assertDoesNotThrow(
                () -> registOrderService.registNewOrder(orderInfo)
        );
    }
}