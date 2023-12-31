package com.ohgiraffers.section01.exception;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExecptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }

        String forwardRequestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String contextPath = (String) request.getAttribute("javax.servlet.forward.context_path");
        String servletPath = (String) request.getAttribute("javax.servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String message = (String) request.getAttribute("javax.servlet.error.message");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String errorRequestURI = (String) request.getAttribute("javax.servlet.error.request_uri");

        System.out.println(forwardRequestURI);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(mapping);
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(mapping.getPattern());
        System.out.println(mapping.getMappingMatch());
        System.out.println(statusCode);
        System.out.println(message);
        System.out.println(servletName);
        System.out.println(errorRequestURI);


        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print(errorPage.toString());

        out.flush();
        out.close();

    }
}

/*에러가 났을 떄 어디로 보*/