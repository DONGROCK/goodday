package com.ohgiraffers.chap02;

import jdk.internal.vm.compiler.collections.Equivalence;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        
        String httpMethod = httpRequest.getMethod();
        System.out.println("httpMethod = " + httpMethod);
        //요청한 http메소드가 어떤건지 판단
        //request요청 ,response응답
        if(("GET").equals(httpMethod)){
            doGet(httpRequest, httpResponse);
        } else if(("POST").equals(httpMethod)){
            doPost(httpRequest, httpResponse);
        }
    }

    //조회가 Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}
