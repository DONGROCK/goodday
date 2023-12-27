package com.ohgiraffers.section01.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first/filter")
public class FirstFilterTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("servlet 요청 확인");

//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");

        response.setContentType("text/html; charset=UTF-8"); // 두개의 설정값을 동시에 적용
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>필터 확인용 서블릿 요청 확인 완료!</h3>");
        out.println("</body>");
        out.println("</html>");

        out.flush();
        out.close();
    }
}
