package com.ohgiraffers.section01.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //로그인을 했을때 그 로그인상태를 유지하기 위해 쿠키생성 사용
        //쿠키는 보안에 취약하다 그래서 중요정보는 쿠키에 남기지 않는다.
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        firstNameCookie.setMaxAge(60 * 60 * 24);// 초단위 (하루
        lastNameCookie.setMaxAge((60 * 60 * 24));

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        //새로운 주소로 새롭게 url요청을 해라! //url요청 GET!!!!!!GET!!!!!!
        /*
         * 쿠키를 사용하는 방법은 간단하다
         * 1. 쿠키를 생성한다.
         * 2. 생성한 쿠키의 만료 시간을 성정한다.
         * 3. 응답헤더에 쿠키를 담는다.
         * 4. 응답한다.
         *
         * 하지만 쿠키는 일부 제약사항이 있다.
         * 쿠키의 이름은 ascii문자만을 사용해야 하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
         * 또한 쿠키의 이름에는 공백문자와 일부 특수문자([] () =,* \ ? @ : ;)*/
        //쿠키는 키,벨류

        response.sendRedirect("redirect");

    }
}