<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/Index1.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="log_bg89">	
    	<div class="top">
       		 <div class="logo"><a href="Index.html"><img src="${pageContext.request.contextPath}/images/titiyigou_logo.png" width="80px" /></a></div>
   		</div>
		<div class="login">
	        	<form>
	            <table border="0"  cellspacing="0" cellpadding="0">
	              <tr height="50" valign="top">
	              	<td width="55">登录</td>
	                <td>
	                	<span class="fl" >&nbsp;</span>
	                    <span class="fr">还没有商城账号，<a href="Regist.html" style="color:#ff4e00;">立即注册</a></span>
	                </td>
	              </tr>
	              <tr height="50">
	                <td>用户名</td>
	                <td><input type="text" value="" class="l_user" /></td>
	              </tr>
	              <tr height="60">
	                <td>密&nbsp;码</td>
	                <td><input type="password" value="" class="l_pwd" /></td>
	              </tr>
	              <tr>
	              	<td>&nbsp;</td>
	                <td >
	                	<span  class="fl">
	                    	<label class="r_rad"><input type="checkbox" /></label><label class="r_txt">请保存我这次的登录信息</label>
	                    </span>
	                    <span class="fr"><a href="#" style="color:#ff4e00;">忘记密码</a></span>
	                </td>
	              </tr>
	              <tr height="60">
	              	<td>&nbsp;</td>
	                <td><input type="submit" value="登录" class="log_btn" /></td>
	              </tr>
	            </table>
	        </form>   
	    </div>
</div>
</body>
</html>