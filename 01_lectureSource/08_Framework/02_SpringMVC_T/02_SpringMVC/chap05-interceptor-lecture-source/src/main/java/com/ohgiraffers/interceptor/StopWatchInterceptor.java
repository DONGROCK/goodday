package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;

/*
* default 메소드 이전에는 모두 오버라이딩 해야하는 책임을 가지기 때문에 HandlerInterceptorAdaptor를
* 이용해 부담을 주열 사용했으나 default메소드가 인터페이스에서 사용가능하게 된 1.8이후부터는
* 인터페이스만 구현하여 필요한 메소드만 오버라이딩 해서 사용할 수 있다.
* */
@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;

    public StopWatchInterceptor(MenuService menuService) {
        this.menuService = menuService;
    }

    /* 전처리 메소드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandler 호출함....");

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);

        /* true 이면 컨트롤러를 이어서 호출한다. false이면 핸들러 메소드를 호출하지 않는다. */
        return true;
    }

    /* 후처리 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandler 호출함...");

        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();

        modelAndView.addObject("interval", endTime - startTime);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterComlete 호출함....");

        menuService.method();
    }
}
