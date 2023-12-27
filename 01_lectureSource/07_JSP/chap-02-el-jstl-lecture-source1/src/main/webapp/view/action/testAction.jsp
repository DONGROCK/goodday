
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="common.jsp"%>
<jsp:include page="common.jsp"/>
    <%
    String str = "";
    
    request.setAttribute("name", "이동락");
    %>

<jsp:forward page="testForward.jsp"></jsp:forward>



</body>
</html>
