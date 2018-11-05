<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
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
	String name=request.getParameter("userName");
	String password=request.getParameter("password");
		//a 判断账号，密码 是否正确（假设账号密码 都一样  为 admin）
		//注意 :("").equals(str)在str为null的时候返回false,str.equals("")在str为null时会抛空指针异常.
		//if(name.equals("admin")&&password.equals("admin")){//报空指针错误
		if("admin".equals(name)&&"admin".equals(password)){
			//3.1.重定向  ( post 无法把数据传递到新的网址中去) 推荐使用
			//response.sendRedirect("index.jsp");
			//3.1.1  重定向  (get可以把数据传递到新的网址中去) 信息暴露 不安全 注意不要忘记连接符号  &
			//response.sendRedirect("index.jsp"+"?userName="+name+"&"+"password="+password);
			//3.1.2 转发	
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			//3.1.3 储存会话  (key ,value)
			session.setAttribute("userName", name);
			session.setMaxInactiveInterval(5); // 以秒为单位 
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			//3.2 （信息打印） 整个页面被重新书写（覆盖以前的）  
			PrintWriter write=response.getWriter(); 
			//登录失败后 加入一个 返回  (建议使用  write )
			//write.print("登录失败"+"   "+"<a href='javascript:window.history.back()'>返回</a>");
			write.write("登录失败"+"   "+"<a href='javascript:window.history.back()'>返回2222</a>");
		}
	%>

</body>
</html>