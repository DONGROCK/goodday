<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h2><a href="view/action/testAction.jsp">jsp Action Tag</a></h2>
<br>
<h1>EL test</h1>
<h3><a href="test1">reqest.getAttribute() 테스트</a></h3>
<h3><a href="test2">reqest에 저장된 객체 출력 테스트</a></h3>
<h3><a href="view/el/testEL3.jsp?name=galaxy&price=95&no=5&no=6&option=삼성">parameter로 값 전달한 경우 el 테스트</a></h3>
<h3><a href="test4">reqestScope와 sessionScope 테스트</a></h3>

<br>

<h1>JSTL test</h1>
<h3><a href="view/jstl/testJstlCore.jsp">Core Library Test</a></h3>
</body>
</html>