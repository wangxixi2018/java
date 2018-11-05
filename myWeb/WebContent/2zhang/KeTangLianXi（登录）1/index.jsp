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
/* //获取方式1：请求
	//1.设置编码格式
		request.setCharacterEncoding("utf-8");
	//2.获取参数
		String name=request.getParameter("userName");
		String password=request.getParameter("password"); */
//获取方式2：会话 （前提 是上一个页面要往会话中放值）
	String name=(String)session.getAttribute("userName");
		if(name==null){
			out.print("***");
		}
%>
	<p>登陆成功<span>欢迎你：<%=name%></span></p>
</body>
</html>