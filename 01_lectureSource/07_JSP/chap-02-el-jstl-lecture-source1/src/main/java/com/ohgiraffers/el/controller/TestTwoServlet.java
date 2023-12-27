package com.ohgiraffers.el.controller;

import com.ohgiraffers.el.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test2")
public class TestTwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO member = new MemberDTO("이동락", 19, "010-2315-1742", "ehdfkr8022@naver.com");

        request.setAttribute("member", member);

        RequestDispatcher rd = request.getRequestDispatcher("view/el/testEL2.jsp");
        rd.forward(request, response);
    }

}