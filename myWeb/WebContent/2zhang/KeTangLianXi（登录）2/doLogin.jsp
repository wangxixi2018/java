<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("user");
	String pwd = request.getParameter("pwd");
	//System.out.println("doLogin---name:"+name+",pwd:"+pwd);
	if("admin".equals(name) && "admin".equals(pwd)){
		//1.重定向   两次请求、地址栏发送改变
		//response.sendRedirect("welcome.jsp?user="+name+"&pwd="+pwd);
		//System.out.println("响应之后的代码。。。");
		//2.转发    同一次请求、地址栏不发生改变
		//存储会话
		session.setAttribute("user", name);
		session.setMaxInactiveInterval(20);//30分钟
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}else{
		//3.信息打印 整个页面被重新书写
		PrintWriter print = response.getWriter();
		print.write("登录失败！！！");
		print.write("<a href='javascript:window.history.back()'>返回</a>");
		print.close();
	}
%>

</body>
</html>