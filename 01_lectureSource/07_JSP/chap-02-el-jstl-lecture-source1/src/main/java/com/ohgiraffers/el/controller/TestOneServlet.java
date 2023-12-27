package com.ohgiraffers.el.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test1")
public class TestOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name","이동락");
        request.setAttribute("age","20");
        request.setAttribute("phone","010-2315-1742");

        List<String> items = new ArrayList<>();
        items.add(new String("apple"));
        items.add(new String("banana"));
        items.add(new String("melon"));

        request.setAttribute("items", items);

        RequestDispatcher rd = request.getRequestDispatcher("view/el/testEL1.jsp");
        rd.forward(request,response);
    }

}