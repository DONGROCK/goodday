package com.ohgiraffers.section01.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

//        response.sendRedirect("redirect");

       HttpSession session = request.getSession();

        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());//유효시간 1800(초)

        session.setMaxInactiveInterval(60* 10); //유효시간을 10분으로 정하겠따.

        System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());

        //한 브라우저당 1개의 아이디 유지가댐 세션을 닫지않으면 유지가 된다.
        System.out.println("session id : " + session.getId());

        session.setAttribute("fristName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("redirect");
    }
}

