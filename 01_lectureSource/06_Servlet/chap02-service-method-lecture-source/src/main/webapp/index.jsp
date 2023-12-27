<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ServiceMethod</title>
</head>
<body>
<h1>service() 메소드의 역할</h1>
<h3>GET방식의 요청</h3>
<h4>a태그의 href속성값 변경</h4>
<a href="request-service">서비스 메소드 요청하기</a>

<h4>form 태그의 method 속성을 get으로 설정</h4>
<form action="request-service" method="get"> <!-- get은 defult값이라 생략가능;-->
    <input type="submit" value="GET방식 요청 전송">
</form>

<h3>POST방식의 요청</h3>
<h4>form 태그의 method 속성을 post로 설정</h4>
<form action="request-service" method="post">
    <input type="submit" value="POST방식 요청 전송">
</form>
<%--GET.,POST,PUT,DELETE 나중에 추가해서 사용할 예정
    GET방식으로 처리되는건
    1. a링크로 만들었을때
    2. form태그의 method에 GET이라고 지정한 경우

    POST방식으로 처리되는건
    1.form태그의 method에 POST라고 지정한 경우
--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>