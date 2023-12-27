<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-11-21
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>전달된 request 객체에 저장된 정보 출력하기</h2>

<%--<%--%>
<%--    String name = (String) request.getAttribute("name");--%>
<%--    int age = (Integer) request.getAttribute("age");--%>
<%--    String phone = (String) request.getAttribute("phone");--%>
<%--%>--%>

<%--name : <%= name%> <br>--%>
<%--age : <%= age%> <br>--%>
<%--phone : <%= phone%>--%>

name : ${name} <br>
age : ${ age } <br>
phone : ${phone}

<br>

<h2>items 이름으로 저장된 리시트 정보 출력하기</h2>
<% ArrayList items = (ArrayList) request.getAttribute("items");%>
<% for (int i = 0; i < items.size(); i++) {%>
    <%= i%> : <%= items.get(i)%> <br>

<% } %>

<br>

0: ${requestScope.items[0]} <br>
0: ${items[0] } <br>
</body>
</html>
