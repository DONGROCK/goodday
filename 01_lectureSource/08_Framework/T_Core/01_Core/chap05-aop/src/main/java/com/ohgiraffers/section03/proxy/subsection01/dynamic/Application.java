package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {


        /*프록시란??
        * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
        * 디자인패턴의 프록시 패턴과는 조금 다른 개념이긴 하다.
        *
        * 실제응용 프로그램을 만들 시 프록시는 직접 기능을 구현할 일은 없다.
        * */

        Student student = new OhgiraffersStudent();
//        student.study(1);

    Student student = new OhgiraffersStudent();
    Handler handler = new Handler(student);

    student proxy = Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[]{student.class}, handler);
    }
}
