package com.ohgiraffers.transactional.section01.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegistOrderService {

    private OrderMapper orderMapper;

    private MenuMapper menuMapper;

    @Autowired
    public RegistOrderService(OrderMapper orderMapper ,MenuMapper menuMapper) {
        this.orderMapper = orderMapper;
        this.menuMapper = menuMapper;
    }

    public void registNewOrder(OrderDTO orderInfo){

        List<Integer> menuCodes = orderInfo.getOrderMenus().stream().map(OrderMenuDTO::getMenuCode).collect(Collectors.toList());

        System.out.println("menuCodes = " + menuCodes);

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);

        List<Menu> menus = menuMapper.findMenusByMenuCode(map);
        System.out.println("menus : " + menus);

        int totalOrderPrice = calcTotalOrderPrice(orderInfo.getOrderMenus(), menus);
        List<OrderMenu> orderMenus = new ArrayList<>(
                orderInfo.getOrderMenus().stream()
                        .map(dto -> {
                            return new OrderMenu(dto.getMenuCode(),dto.getOrderAmount());
                        }).collect(Collectors.toList())
        );

        Order order = new Order(orderInfo.getOrderDate(), orderInfo.getOrderTime(), totalOrderPrice, orderMenus);
        System.out.println("order = " + order);

        orderMapper.registOrder(order);

        System.out.println("==========> " + order);
    }



    private int calcTotalOrderPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {

    int totalOrderPrice = 0;

    int orderMenuSize = orderMenus.size();

    for(int i = 0; i < orderMenuSize; i++){
        OrderMenuDTO orderMenu = orderMenus.get(i);
        Menu menu = menus.get(i);
        totalOrderPrice += menu.getMenuPrice() * orderMenu.getOrderAmount();
    }

    return totalOrderPrice;
    }

}
