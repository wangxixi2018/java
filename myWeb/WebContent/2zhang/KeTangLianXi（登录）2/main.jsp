<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session:会话  客户端与服务器在时间段内的连续对话 -->
<%=session.getId() %>
<%
	String name = (String)session.getAttribute("user");
	if(name == null){//登录失效、未登录
		%>
		<p>未登录！请重新<a href="login.html">登录</a></p>
<%		
	}else{
%>
	欢迎您:<%=name %>，登录成功！！
主页
<%		
	}
%>

</body>
</html>