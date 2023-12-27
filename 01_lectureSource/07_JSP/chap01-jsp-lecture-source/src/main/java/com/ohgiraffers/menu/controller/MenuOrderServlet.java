package com.ohgiraffers.menu.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String menuName = request.getParameter("menuName");
        int amount = Integer.parseInt(request.getParameter("amount"));

        System.out.println("menuName = " + menuName);
        System.out.println("amount = " + amount);

        //비지니스 로직처리...
        int orderPrice = 0;

        switch (menuName){
            case "햄버거" : orderPrice = 6000 * amount; break;
            case "짜장면" : orderPrice = 7000 * amount; break;
            case "짬뽕" : orderPrice = 9000 * amount; break;
            case "순대국" : orderPrice = 10000 * amount; break;
        }

        request.setAttribute("menuName",menuName);
        request.setAttribute("amount",amount);
        request.setAttribute("orderPrice",orderPrice);

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(request, response);






    }
}