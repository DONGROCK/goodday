package com.ohgiraffers.section01.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")// 모든 것들을 다 위임 처리
public class ReceiveInformationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getparametervalues 체크박스
        /*post일 경우는 요청받을 경우에 한글이 있을 수 있기 때문에 인코딩 설정을 해준다.*/
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        //비지니스로직처리
        /*
        * 어떤 서블릿으로 위임할 것 인지 대상 서블릿을 지정하는 인스턴스를 생성하고,
        * forward() method를 요청과 응답에 대한 정보를 전달하여 나머지 작업을 수행하도록 위임한다.
        * 이때 다른 서블릿으로 요청하기 위한 데이터는 request에 setAttribute로 전달하여 받는
        * 쪽에서 getAttribute를 이용해 꺼내서 사용한다.
        * */
        request.setAttribute("newUserId", userId); //request.getParameter가아닌 다시 담아서 보내는

        RequestDispatcher rd = request.getRequestDispatcher("print"); //rd = 내가 어디로 보낼지 지정
        rd.forward(request, response);
    }
}