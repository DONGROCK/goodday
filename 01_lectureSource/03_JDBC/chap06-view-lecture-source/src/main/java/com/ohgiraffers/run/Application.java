package com.ohgiraffers.run;

import com.ohgiraffers.model.dao.OrderDAO;
import com.ohgiraffers.view.OrderMenu;

public class Application {
    public static void main(String[] args) {

        new OrderMenu().displayMainMenu();
    }
}
