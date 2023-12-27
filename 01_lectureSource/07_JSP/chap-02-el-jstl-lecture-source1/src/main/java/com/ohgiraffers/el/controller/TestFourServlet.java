package com.ohgiraffers.el.controller;

import com.ohgiraffers.el.model.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MemberDTO sessionMember = new MemberDTO("이동락", 20, "010-2315-1742", "ehdfkr8022@naver.com");
        MemberDTO requestMember = new MemberDTO("박재범", 20, "010-2222-2222", "jpark@naver.com");

        HttpSession session = request.getSession();

        request.setAttribute("member", requestMember);
        session.setAttribute("member",sessionMember);

        RequestDispatcher rd = request.getRequestDispatcher("view/el/testEL4.jsp");
        rd.forward(request, response);

    }

}