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
		//1.创建cookie //由于只能储存量小 值为字符串类型： 一般保存账号和密码~~
		Cookie cookie=new Cookie("name","admin");
		//2.添加cookie
		response.addCookie(cookie);
		//3.获取cookie (因有多个cookie 获取的是数组 )
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
//由于机制是现请求一次服务器后拿到 sessionid再客户端把sessionid存入客户端的Cookie中,
//所有在第一次请求服务器是在客户端中并没有Cookie 也就是request.getCookies() 为空
			for(Cookie c:cookies){
				out.print(c.getName()+"=="+c.getValue());
			}
		}
	%>
</body>
</html>