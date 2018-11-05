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
		//session.invalidate(); 清楚会话的全部属性值,清空
		if(user.getSole()==1){//普通用户清楚会话 但保留当前页面
			session.removeAttribute("user"); //删除属性为user的属性名与值
			
		}else if(user.getSole()==2){//管理员清楚会话，并重定向登录页面
			session.removeAttribute("user");
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>