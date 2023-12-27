package com.ohgiraffers.section01.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/response") // 슬래시 꼭 잘쓰기
public class ResponseTestServlet extends HttpServlet {
    /*
     * 서블릿이 하는 역할은 크게 3가지이다.
     * 1. 요청받기 = HTTP method GET/POST 요청에 따라 parameter로 전달받은 데이터를 꺼내올 수 있다.
     * 2. 비지니스 로직 처리 - DB접속과 CRUD에 대한 로직 처리 -> 서비스를 호출하는 쪽으로 해결(MVC)한다.
     * 3. 응답하기 - 문자열로 동적인 웹(HTML 태그)페이지를 만들고 스트림을 이용해 내보낸다.
     *      컨트롤러와 유사
     *
     * 사용자 브라우저에 응답하기 위해서는 HttpServletResponse의 getWriter() method로 PrintWriter 인스턴스를 반환한다.
     * PrintWriter는 BufferedWriter와 형제격인 클래스이지만 더 많은 형태의 생성자를 제공하고 있는 범용성으로 인해 더 많이 사용된다.
     * */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder responseBuilder = new StringBuilder();

        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>헬로 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        /*
        * 브라우저로 내보낼 데이터의 타입을 응답 헤더에 설정해준다.
        * content-type 헤더의 값은 null이 기본값이며 명시하지 않으면 text/plain(MIME타입)을 설정한다.
        * */

        System.out.println("default response type: " + response.getContentType());

        /*
        * 기본값은 text/plain이지만 html태그를 사용하면 오청 시 text/html 도 응답을 수락 가능하도록 헤더 설정이 되어 있어
        * 자동으로 text/html로 인식한다. 하지만 text/plain으로 설정하게 되면 html태그를 태그로 인식하지 않고 문자열로 인식한다.
        * */
        response.setContentType("text/html");

        /*응답 시에도 별도 인코딩을 지정하지 않으면 기본으로 설정된 인코딩 방식을 따른다.(ISO-8859-1)
        * 따라서 한글을 포함한 페이지를 응답하는 경우 글자가 깨저서 출력된다.
        * */
        System.out.println("default response encoding : " + response.getCharacterEncoding());

        response.setCharacterEncoding("UTF-8");
        System.out.println("changed response encoding : " + response.getCharacterEncoding());

        /*
        * 응답할 인코딩 방식이 UTF-8임을 응답헤더에 알려주면 브라우저가 이를 해석할 때 UTF-8로 인식해서 해석한다.
        * 따라서 한글이 깨지지 않고 출력된다. 주의할 점은 반드시 getWriter()로 스트림을 얻어오기 전에 설정해야한다.
        * */

        PrintWriter out = response.getWriter();

        //참고로 위의 두개의 설정을 한번에 설정할 수 있따.
        //response.setContentType("text/html; charset=utf-8")'

        out.println(responseBuilder.toString());

        out.flush();

        out.close();
    }

}