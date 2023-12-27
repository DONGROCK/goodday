package com.ohgiraffers.section02.sessionlistener;

import com.ohgiraffers.section01.sessionlistener.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("발급받은 session id : " + session.getId());

        session.setAttribute("uesrname", "honggildong");
        session.setAttribute("age", 20);
        session.setAttribute("gender", "M");

        session.setAttribute("user", new UserDTO("honggildong",20));

        session.setAttribute("username", "hong"); //변경된거

        session.removeAttribute("gender");

//        session.setMaxInactiveInterval(2);
        session.invalidate();
    }
}
