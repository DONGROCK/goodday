
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>testForward</title>
</head>
<body>
<h1><%=request.getAttribute("name")%>님 환영합니다.</h1>

<h2>jsp:useBean 활용하기</h2>

<jsp:useBean id="member" class="com.ohgiraffers.el.model.dto.MemberDTO" scope="page"/>
<jsp:setProperty name="member" property="name" value="이동락"/>
<jsp:setProperty name="member" property="age" value="20"/>
<jsp:setProperty name="member" property="phone" value="010-2315-1742"/>
<jsp:setProperty name="member" property="email" value="ehdfkr8022@naver.com"/>

이름: <jsp:getProperty name="member" property="name"/>
<br>
나이: <jsp:getProperty name="member" property="age"/>
<br>
전화번호: <jsp:getProperty name="member" property="phone"/>
<br>
이메일: <jsp:getProperty name="member" property="email"/>

<!--자료형이 맞지 않은 자료를 넣을 시 500에러가 뜨게 된다.-->

</body>
</html>
