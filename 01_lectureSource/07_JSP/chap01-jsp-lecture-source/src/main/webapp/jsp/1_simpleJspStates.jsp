

<!--
페이지에 대한 설정을 하는 지시자 태그이다.
현재 페이지에 스크립틀릿 태그를 이용하여 작성하는 문법은 java라는 의미이며,
response header에 응답을 위한 설정도 할 수 있다.
content-type이라는 헤더에 MIME타입과 인코딩방식을 지정한다.
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
    JSP는 표면상으로는 HTML과 유사하다.
    하지만 JSP 컨테이너가 최초 JSP 요청 시 JSP를 서블릿으로 변환시키고, 서블릿 컨테이너가 변환된 서블릿을
    이용해서 인스턴스를 생성하고 호출한다.
    JSP는 요청 시마다 기존 JSP 파일이 변환되었는지를 확인하여 변경이 없으면 기존에 생성한 인스턴스를 사용하고,
    변경이 있으면 translate과정을 통해 인스턴스를 재생성한다.

    jsp작동 순서는 translate -> compile -> instance 생성 -> run
-->
<!-- jsp 주석 태그 -->
<%-- html 주석은 클라이언트에 노출되지만, jsp주석은 클라이언트에게 노출 되지 않는다.--%>
<!--선언 태그
    서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언한다.
-->
<%!
    private  String name;
    private  int age;
%>

<!-- scriptlet 태그
    간단한 자바 코드를 작성할 수 있는 부분
    -->

<%
    name = "홍길동";
    age = 20;

    System.out.println("name = " + name);
    System.out.println("age = " + age);

    for (int i = 0; i < name.length(); i++){
        System.out.println(name.charAt(i));
    }
%>

<!-- expression 태그-->
<!-- PrintWriter를 이용하여 브라우저에 값을 내보내 브라우저에서 보여지게 된다.
    자바 코드로 변환 시 out.print(); 괄호 안에 expression태그 내에 작성한 내용이 들어간다.
    정상적으로 출력한 값을 작성하는 경우 out.print(name); 이런 식으로 표현되는데
    expression 태그 내에 세미콜론을 작성하면 out.print(name;); 형태가 되므로 compile 에러가 발생한다.
-->
    name : <%= name%>
    age : <%= age%>

</body>
</html>




