package com.ohgiraffers.section02.formdata;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //기본설정 인코딩 방식이 null로 출력
        //이는 톰캣의 기본 세팅 값인 ISO-8859-1로 디코딩을 시도한다
        System.out.println(request.getCharacterEncoding());

        //파라미터값을 꺼내기 전에 디코딩할 인코딩 방식을 설정하면 설정한 방식으로 페이로드의 값을 해석된다.
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        System.out.println("이름 : " + name);

        //인코딩을 제외한 나머지 값들은 GET방식에서 값을 꺼내온 것과 동일하다.

        //요청한 데이터의 key값과 value를 조회
        Map<String, String[]> requestMap = request.getParameterMap();
        Set<String> keyset = requestMap.keySet();
        Iterator<String> keyIter = keyset.iterator();

        while (keyIter.hasNext()){
            String key = keyIter.next();
            String[] value = requestMap.get(key);

            System.out.println("key : " + key);

            for (int i =0; i < value.length; i++){
                System.out.println("value[" + i + "]" + value[i]);
            }
        }

        //파라미터로 전달된 키 목록만 조회
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            System.out.println(names.nextElement());
        }
    }
}
