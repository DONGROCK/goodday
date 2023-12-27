package com.ohgiraffers.section02.sessionlistener;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListenerTest() {
        // context가 로드될 때 인스턴스가 생성된다. -> 톰캣이 실행될때 SessionListenerTest라는 인스턴스를 생성해준다.
        System.out.println("session listener 인스턴스 생성");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 세션이 생성될 떄 동작
        System.out.println("session created!!");
        System.out.println("생성된 session id : " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 세션이 만료될 시 동작
        System.out.println("session destoryed!!");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //session에 attribute가 추가될 때 동장
        System.out.println("session attribute added!!");
        System.out.println("session에서 추가된 attr : " + event.getName() + ", " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!!");
        System.out.println("session에서 제거된 attr : " + event.getName() + ", " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
       //session의 attribute가 갱신될 때 동작
        System.out.println("session attribute replaced!!");
        System.out.println("srssion에서 수정된 attr : " + event.getName() + ", " + event.getValue());
    }
}
