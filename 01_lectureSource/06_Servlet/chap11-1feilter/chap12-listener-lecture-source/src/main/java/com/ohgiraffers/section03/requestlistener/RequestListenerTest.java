package com.ohgiraffers.section03.requestlistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {
    public RequestListenerTest() {
        //context가 로드 될 때 생성자 호출하여 인스턴스는 생성
        System.out.println("request listener인스턴스 생성");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //request가 소멸 될 때 호출
        System.out.println("request destoryed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //request가 생성 될 때 호출
        System.out.println("request init!!");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        //request에 attribute가 추가될 떄 호출
        System.out.println("request attribute added!!");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        //request에 attribute가 제거될 때 호출
        System.out.println("request attribute removed!!");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        //request에 attribute가 갱신 될 떄 호출
        System.out.println("request attribute replaced!!");
    }

}
