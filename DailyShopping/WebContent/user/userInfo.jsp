<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function calloffdo(){
		$(".showUpdateUserInfo").remove();
		$("#updateButton").show();
		$(".updateUserInfo").show();
	}
	
	function doUpdateUserInfo(){
		var username = document.getElementById("username");
		var userage = document.getElementById("userage");
		var userphone = document.getElementById("userphone");
		var useremail = document.getElementById("useremail");
		var usercarid = document.getElementById("usercarid");
		var usersex = document.getElementById("usersex");
		var useraddress = document.getElementById("useraddress");
		$.post(
			"../user.do?opr=updateUserInfo",
			{"username":username.value,"userage":userage.value,"userphone":userphone.value,"useremail":useremail.value,"usercarid":usercarid.value,"usersex":usersex.value,"useraddress":useraddress.value},
			function(data){
				refurbishusers();
			},
			"json"
		);
	}
</script>
</head>
<body>
<form action="" style="margin:10px" method="post">
	<table style="margin-left:10px;width:790px">
		<tr>
			<td style="width:60px">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
			<td><input type="text" name="username" id="username" value="<c:out value='${user.u_realName}'/>"></td>
			<td style="width:50px"></td>
			<td style="width:60px">年&nbsp;&nbsp;&nbsp;&nbsp;龄:</td>
			<td><input type="text" name="userage" id="userage" value="<c:out value='${user.u_age}'/>"></td>
			<td style="width:50px"></td>
			<td style="width:60px">电&nbsp;&nbsp;&nbsp;&nbsp;话:</td>
			<td><input type="text" name="userphone" id="userphone" value="<c:out value='${user.u_phone}'/>"></td>
		</tr>
		<tr style="height:10px"></tr>
		<tr>
			<td style="width:60px">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
			<td><input type="email" name="useremail" id="useremail" value="<c:out value='${user.u_email}'/>"></td>
			<td style="width:50px"></td>
			<td style="width:60px">身份证:</td>
			<td><input type="text" name="usercarid" id="usercarid" value="<c:out value='${user.u_papers}'/>"></td>
			<td style="width:50px"></td>
			<td style="width:60px">性&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
			<td>
			<c:set var="users2" value="${user}" scope="session"></c:set>
				<select id="usersex">
					<c:if test="${users2.u_sex=='男'}">
						<option value="男">男</option>
						<option value="女">女</option>
					</c:if>
					<c:if test="${users2.u_sex=='女'}">
						<option value="女">女</option>
						<option value="男">男</option>
					</c:if>
				</select>
			</td>
		</tr>
		<tr style="height:10px"></tr>
		<tr>
			<td>住&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
			<td colspan="7"><input type="text" name="useraddress" id="useraddress" style="width:450px" value="<c:out value='${user.u_address}'/>"></td>
		</tr>
	</table>
	<div style="margin-left:730px;margin-top:40px"><input type="button" value="确定" onclick="doUpdateUserInfo()">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="取消" onclick="calloffdo()"></div>
	
</form>
</body>
</html>