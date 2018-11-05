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
		String name=request.getParameter("userNmae");
		String password=request.getParameter("password");
		session.setAttribute("user", name);
		session.setAttribute("pwd", password);
		session.setMaxInactiveInterval(30);
	%>
	<%
		if("lucky".equalsIgnoreCase(name)&&"123456".equalsIgnoreCase(password)){
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			response.sendRedirect("mailLogin.jsp");
		}
	%>
</body>
</html>