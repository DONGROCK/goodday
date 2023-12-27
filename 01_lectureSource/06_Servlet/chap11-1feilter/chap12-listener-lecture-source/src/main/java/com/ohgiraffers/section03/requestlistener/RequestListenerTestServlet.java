package com.ohgiraffers.section03.requestlistener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setAttribute("username","honggildong");
    request.setAttribute("age","22");
    request.setAttribute("gender","M");

    request.setAttribute("username", "hong");

    request.removeAttribute("gender");
    }

}