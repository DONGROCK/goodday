package com.ohgiraffers.section01.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Spliterator;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /*
        * 쿠키를 사용하는 방법도 간단하다*/

        Cookie[] cookies = request.getCookies();
        for(int i  = 0; i < cookies.length; i++){
            System.out.println("[cookie] = " + cookies[i].getName() + " : " + cookies[i].getValue());

             if ("firstName".equals(cookies[i].getName())){
                 firstName = cookies[i].getValue();
             }else if("lastName".equals(cookies[i].getName())){
                 lastName = cookies[i].getValue();
             }
        }

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>your first name is ")
                .append(firstName)
                .append(" and last name is ")
                .append(lastName)
                .append("</h3>")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(responseText.toString());

        out.flush();
        out.close();





    }
}