<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("user");
%>
欢迎您:<%=name %>，登录成功！！
<a href="main.jsp">进入主页</a>
</body>
</html>