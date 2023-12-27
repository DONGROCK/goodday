package com.ohgiraffers.section02.uses;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingType;
    public void init(FilterConfig fconfig) throws ServletException {

        /* xml에 설정한 init-param의 key를 이용하여 fconfig에서 값을 꺼내올 수 있다. */
        encodingType = fconfig.getInitParameter("encoding-type");
    }

    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest hrequest = (HttpServletRequest) request;
        if("POST".equals(hrequest.getMethod())){
            request.setCharacterEncoding(encodingType);
            System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding());
        }

        chain.doFilter(request, response);
    }
}
