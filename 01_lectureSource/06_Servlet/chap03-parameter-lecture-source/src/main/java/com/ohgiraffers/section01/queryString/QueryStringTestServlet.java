package com.ohgiraffers.section01.queryString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        System.out.println("이름 : " + name + "입니다.");
        /*getParameter는 return타입이 문자열이다.*/
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("나이 : " + age + "입니다.");

        Date birthday = Date.valueOf(request.getParameter("birthday"));
        System.out.println("생일: " + birthday);

        String gender = request.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = request.getParameter("national");
        System.out.println("국적 = " + national);

        //다중으로 입력을 받을 수 있는 checkbox의 경우는
        //선택된 값이 문자열 배열로 전달된다.
        //getParameterValues() 메소드를 이용하여 문자열 배열 형태로 값을 반환받을 수 있따.
//        System.out.println("취미 = ");
        String[] hobbies = request.getParameterValues("hobbies");
        for(String hobby : hobbies){
            System.out.println("취미 = " + hobby);
        }
    }
}