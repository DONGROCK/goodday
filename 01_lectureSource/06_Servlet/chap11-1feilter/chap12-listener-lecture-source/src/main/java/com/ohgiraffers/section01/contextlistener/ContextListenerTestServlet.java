package com.ohgiraffers.section01.contextlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("context listener 확인용 서블릿");

        ServletContext context = request.getServletContext();
        // context에 attr을 추가하면 attributeAdded()메소드가 동작
        context.setAttribute("test", "value");
        // 동일한 key로 context에 attr을 추가하면(수정) attributeReplaced()메소드가 동작
        context.setAttribute("test", "value2");
        // context에서 attr를 제거하면 attributeRemoved()메소드가 동작
        context.removeAttribute("test");
    }

}