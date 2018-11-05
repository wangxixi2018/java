<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱登录信息验证</title>
<style type="text/css">
body {
	width: 1300px
}

div {
	width: 756px;
	border: 1PX solid red;
	margin: auto;
	position: relative;
}

table {
	position: absolute;
	top: 200px;
	left: 300px;
}
</style>
</head>
<body>
	<div>
		<img src="images/Snap1.jpg">
		<form action="index.jsp" method="post">
			<table>
				<tr>
					<td align="right" valign="top">用户名:</td>
					<td><input name="userNmae"><br />
					<span>用户名由字母和数字组成</span></td>
				</tr>
				<tr>
					<td align="right" valign="top">密码:</td>
					<td><input type="password" name="password"><br />
					<span>密码由字母、数字和下划线组成，至少6位</span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="image" src="images/login.gif" value="提交">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
