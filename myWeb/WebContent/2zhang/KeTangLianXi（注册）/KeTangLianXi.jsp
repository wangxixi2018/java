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
	//1.设置编码格式
		request.setCharacterEncoding("utf-8");
	//2.获取参数
		String name=request.getParameter("userNames");
		String password=request.getParameter("passwords");
		String repassword=request.getParameter("repasswords");
		String[] checkbox=request.getParameterValues("checkbox");
	%>
	<p>用户名: <span><%=name %></span></p>
	<p>密码：<span><%=password %></span></p>
	<p>重复密码：<span><%=repassword %></span></p>
	<p>信息来源：<span><%
		for(String str:checkbox){
			%>
				<span><%=str %></span>
			<%
		}
	%></span></p>
</body>
</html>