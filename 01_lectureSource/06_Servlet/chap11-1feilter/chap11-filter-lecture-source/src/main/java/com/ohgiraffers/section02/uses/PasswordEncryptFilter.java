package com.ohgiraffers.section02.uses;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// member 서비스인 경우에만 암호화 처리 할 수 있도록 한다.
@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {

    public PasswordEncryptFilter() {
        System.out.println("PasswordEncryptFilter 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) request;
        // 요청에 대한 수정 작업
        RequestWrapper wrapper = new RequestWrapper(hrequest);

        chain.doFilter(wrapper, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
