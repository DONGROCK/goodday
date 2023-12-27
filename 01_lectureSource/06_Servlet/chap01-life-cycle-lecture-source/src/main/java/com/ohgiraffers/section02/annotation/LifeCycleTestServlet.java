package com.ohgiraffers.section02.annotation;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * loadOnStartup 속성으로 우선순위를 지정 할 수 있으며 (숫자가 낮을수록 우선순위가 높음)
 * 서버가 start될 떄 인스턴스를 생성하고 init()를 호출한다.
 */
@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTestServlet extends HttpServlet {

    //각 메소드의 호출 횟수를 카운트할 목적의 필드
    private int inintCount = 1;
    private int serviceCount = 1;
    private int destoryCount = 1;

    @Override
    public void init() throws ServletException {
        System.out.println("annotation매핑 init()메소드 호출 : " + inintCount++);
    }

    /**
     * 컨테이너가 종료될 때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용
     */
    @Override
    public void destroy() {
        System.out.println("annotation매핑 destroy() 메소드 호출 : " + destoryCount++);
    }

    /**
     * 서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후 동작하고
     * 두번째 요청부터는 init()호출 없이 바로 service()를 호출한다.
     * @param req   the {@link HttpServletRequest} object that
     *                  contains the request the client made of
     *                  the servlet
     *
     * @param res   the {@link HttpServletResponse} object that
     *                  contains the response the servlet returns
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation매핑 service() 메소드 호출 : " + serviceCount++);
    }
}



//서블릿이 컨트롤러 역할이랍니다.