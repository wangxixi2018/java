<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function updateuserpassword(){
		var falg1 = false;
		var falg2 = false;
		var falg3 = false;
		if($(".oldpassword").val()==""||$(".oldpassword").val()==null){
			$(".m_des span:eq(0)").html("原密码不能为空").css("color","red");
		}else{
			$(".m_des span:eq(0)").html("");
			falg1 = true;
		}
		if($(".newpassword").val()==""||$(".newpassword").val()==null){
			$(".m_des span:eq(1)").html("新密码不能为空").css("color","red");
		}else{
			$(".m_des span:eq(1)").html("");
			var pwd = $(".newpassword").val().trim();
	        if(pwd.length>=6&&pwd.length<=16){
	            reg = /^[a-zA-Z0-9_]+$/;
	            if (reg.test(pwd)){
	            	$(".m_des span:eq(1)").html("");
	            	falg2 = true;
	            }else{
	            	$(".m_des span:eq(1)").html("密码格式不满足要求").css("color","red");
	            	falg2 = false;
	            }
	        }else{
	        	$(".m_des span:eq(1)").html("密码长度不满足要求").css("color","red");
	            falg2 = false;
	        }
		}
		if($(".renewpassword").val()==""||$(".renewpassword").val()==null){
			$(".m_des span:eq(2)").html("确认新密码不能为空").css("color","red");
		}else{
			$(".m_des span:eq(2)").html("");
			if($(".renewpassword").val()==$(".newpassword").val()){
				$(".m_des span:eq(2)").html("");
				falg3 = true;
	        }else{
	        	$(".m_des span:eq(2)").html("密码不同，请重新输入！").css("color","red");
	        	falg3 = false;
	        }
		}
		if(falg1==true&&falg2==true&&falg3==true){
			passworddataupdate();
		}
	}
	function passworddataupdate(){
		$.post(
				"../user.do?opr=updateuserpassword",
				{"oldpassword":$(".oldpassword").val(),"newpassword":$(".newpassword").val()},
				function(data){
					if(data=="true"){
						$(".outinfotopage").html("");
						$(".outinfotopage").html("修改成功").css("color","green");
						$(".add_ipt").val("");
					}
					if(data=="false"){
						$(".outinfotopage").html("");
						$(".outinfotopage").html("修改失败").css("color","red");
					}
					if(data=="pwdnoequals"){
						$(".outinfotopage").html("");
						$(".add_ipt").val("");
						$(".m_des span:eq(0)").html("原密码输入错误").css("color","red");
						$(".outinfotopage").html("修改失败").css("color","red");
					}
				},
				"json"
			);
	}
</script>
</head>
<body>
			
            <div class="mem_tit">账户安全</div>
            <div class="m_des">
                <form>
                <table border="0" style="width:500px;"  cellspacing="0" cellpadding="0">
                  <tr height="45px">
                    <td width="80px" align="right">原密码 &nbsp; &nbsp;</td>
                    <td style="width:200px;"><input type="password" name="oldpassword" class="add_ipt oldpassword" style="width:180px;" />&nbsp; <font color="#ff4e00">*</font></td>
                    <td width="200px"><span></span></td>
                  </tr>
                  <tr height="45px">
                    <td align="right">新密码 &nbsp; &nbsp;</td>
                    <td><input type="password" name="newpassword" class="add_ipt newpassword" style="width:180px;" />&nbsp; <font color="#ff4e00">*</font></td>
                  	<td ><span></span></td>
                  </tr>
                  <tr height="45px">
                    <td align="right">确认密码 &nbsp; &nbsp;</td>
                    <td><input type="password" name="renewpassword" class="add_ipt renewpassword" style="width:180px;" />&nbsp; <font color="#ff4e00">*</font></td>
                  	<td><span></span></td>
                  </tr>
                  <tr height="50px">
                    <td>&nbsp;</td>
                    <td><input type="button" value="确认修改" class="btn_tj" onclick="updateuserpassword();"/></td>
                  </tr>
                  <tr height="50px"><td></td><td><p style="width:200px;" class="outinfotopage"></p></td></tr>
                </table>
                </form>
            </div>         
   
</body>
</html>