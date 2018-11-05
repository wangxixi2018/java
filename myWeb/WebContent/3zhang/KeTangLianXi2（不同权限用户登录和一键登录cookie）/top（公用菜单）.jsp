<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="KeTangLianXi3.User" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
<%
	//判断会话失效或登录失败
	User user=((User)session.getAttribute("user"));//获取session 中userd的值：为User对象Boj需要强转
	if(user==null){
		response.sendRedirect("login.jsp");//重定向到登录页面
		return;//中断页面后面的内容的展现，后面页面就不会被打印
	}
%>

		登录成功  欢迎：<%=((User)session.getAttribute("user")).getName()%>
			<a href="indexOut.jsp">注销</a>
			<a href="index.jsp">菜单一</a>
			<a href="index.jsp">菜单二</a>
			<%
			if(user.getSole()==2){
				%>
					<a href="index2.jsp">后台菜单</a>
				<%
			}
			%>
			
</body>
</html>