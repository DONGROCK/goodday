<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-11-21
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>requestScope와 sessionScope 테스트</h2>

<h3>requestScope 값 출력하기</h3>
이름 : ${ requestScope.member.name } <br>
나이 : ${ requestScope.member.age } <br>
전화번호 : ${ requestScope.member.phone } <br>
이메일 : ${ requestScope.member.email } <br>
<hr>
<h3>sessionScope 값 출력하기</h3>
이름 : ${ sessionScope.member.name } <br>
나이 : ${ sessionScope.member.age } <br>
전화번호 : ${ sessionScope.member.phone } <br>
이메일 : ${ sessionScope.member.email } <br>
<h2>requestScope와 sessionScope 테스트</h2>

<%-- 스코프의 탐색의 범위는 좁은 범위에서 넓은 범위로 탐색을
 하고 해당 스코프에 찾으려는 이름이 같으면 해당 값을 출력한다.--%>
<h3>우선순위 테스트</h3>
이름 : ${ member.name } <br>
나이 : ${ member.age } <br>
전화번호 : ${ member.phone } <br>
이메일 : ${ member.email } <br>

</body>
</html>
