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
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("txtUser");
		String txtPass=request.getParameter("txtPass");
		 String txtRPass=request.getParameter("txtRPass");
		String[] gen=request.getParameterValues("gen"); 
		String txtEmail=request.getParameter("txtEmail");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
	%>
	<p>姓名：<%=name %></p>
	<p>密码：<%=txtPass %></p>
	<p>重复密码：<%=txtRPass %></p>
	<p>重复密码：<%
		for(int i=0;i<gen.length;i++){
			%>
				性别：<span><%=gen[i] %></span>
			<%
		}
	%></p>
	<p>电子邮件地址：<%=txtEmail %></p>
	<p>出生日期：<%=year %>年<%=month %>月<%=day %>日</p>
</body>
</html>