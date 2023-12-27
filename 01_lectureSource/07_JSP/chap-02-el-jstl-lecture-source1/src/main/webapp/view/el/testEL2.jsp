<%@ page import="com.ohgiraffers.el.model.dto.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-11-21
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>전달된 request 객체에 저장된 Member 객체 필드값 출력하기</h2>

<%--${저장이름.필드명}--%>
<% MemberDTO member = (MemberDTO) request.getAttribute("member");%>

이름 : <%= member.getName() %>

<br>

이름: ${requestScope.member.name} <br>
나이: ${requestScope.member.age} <br>

<br>
이름: ${member.name} <br>
나이: ${member.age} <br>


</body>
</html>
