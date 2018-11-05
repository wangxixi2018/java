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
		Cookie[]cookie=request.getCookies();
		String userName=null;
		String password=null;
		if(cookie!=null){
		//由于机制是现请求一次服务器后拿到 sessionid再客户端把sessionid存入客户端的Cookie中,
		//所有在第一次请求服务器是在客户端中并没有Cookie 也就是request.getCookies() 为空
			for(Cookie c:cookie){
				if(c.getName().equalsIgnoreCase("userName")){
					userName=c.getValue();
				}
				if(c.getName().equalsIgnoreCase("passeord")){
					password=c.getValue();
				}
			}
	}
	%>
	<form action="dologin.jsp" method="post">
		用户名：<input name="userName"value="<%=userName==null?"":userName%>">&nbsp;&nbsp;
		密码：<input type="password" name="password" value="<%=password==null?"":password%>">&nbsp;&nbsp; 
		<input type="checkbox" name="cookie" checked="checked">记住密码 &nbsp;&nbsp;
			<input type="submit" value="登录">
	</form>
</body>
</html>