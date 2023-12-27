package com.ohgiraffers.section01.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("RedirectServlet.doGet firstName : " + firstName);
        System.out.println("RedirectServlet.doGet lastName : "  + lastName);

        HttpSession session = request.getSession();
        System.out.println("redirect 페이지 session id : " + session.getId());

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        firstName = (String) session.getAttribute("fristName");
        lastName = (String) session.getAttribute("lastName");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Your first name is ");
        out.println(firstName);
        out.println(" and last name is ");
        out.println(lastName);
        out.println("</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }

}