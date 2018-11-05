<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="input_TiJiao.jsp" %> 
	<table>
		<caption>请输入注册信息</caption>
		<tr>
			<td>用户名</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><%=password %></td>
		</tr>
		<tr>
			<td>来源信息</td>
			<td>
			<% 
				for(String i:checkbox){
					out.print(i+" ");
				}
			%>
			</td>
		</tr>
	</table>
</body>
</html>