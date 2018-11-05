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
	
	function showaddress(){
		$(".showaddress").show();
		notddoupdateuseraddress();
	}
	function notshowaddress(){
		$(".showaddress").hide();
		$(".add_ipt").val("");
		$("#showInfo1").html("");
	}
	function doupdateuseraddress(id){
		notshowaddress();
		var o_takeSiteID = id;
		$.post(
			"../Consignee_Info.do?opr=doupdateuseraddress",
			{"o_takeSiteID":o_takeSiteID},
			function(data){
				$(".update_ipt").val("");
				$("#RecordId").val(o_takeSiteID);
				$(".update_ipt:eq(0)").val(data.o_area);
				$(".update_ipt:eq(1)").val(data.o_name);
				$(".update_ipt:eq(2)").val(data.o_phone);
				$(".update_ipt:eq(3)").val(data.o_add);
				$(".update_ipt:eq(4)").val(data.o_code);
				$(".showupdateaddress").show();
			},
			"json"
		);
	}
	function notddoupdateuseraddress(){
		$(".showupdateaddress").hide();
		$(".update_ipt").val("");
		$("#showInfo1").html("");
	}
	
	function adduseraddresssuer(u_id){
		var s1 = $(".jj:eq(0)").val();
		var s2 = $(".jj:eq(1)").val();
		var s3 = $(".jj:eq(2)").val();
		var areas = s1+s2+s3;
		var name = $(".add_ipt:eq(0)").val();
		var phone = $(".add_ipt:eq(1)").val();
		var address = $(".add_ipt:eq(2)").val();
		var code = $(".add_ipt:eq(3)").val();
		$.post(
			"../Consignee_Info.do?opr=adduseraddresssuer",
			{"areas":areas,"name":name,"phone":phone,"address":address,"code":code,"u_id":u_id},
			function(data){
				if(data=="true"){
					$(".m_right").empty();
					$(".m_right").load("../user/useraddress.jsp");
					$("#showInfo1").html("添加成功").css("color","green");
				}else{
					$("#showInfo1").html("添加失败").css("color","red");
				}
			},
			"json"
		);
	}
	function suerdoupdateuseraddress(id){
		var u_id = id;
		var o_takeSiteID = $("#RecordId").val();
		var areas = $(".update_ipt:eq(0)").val();
		var name = $(".update_ipt:eq(1)").val();
		var phone = $(".update_ipt:eq(2)").val();
		var address = $(".update_ipt:eq(3)").val();
		var code = $(".update_ipt:eq(4)").val();
		$.post(
			"../Consignee_Info.do?opr=suerdoupdateuseraddress",		
			{"areas":areas,"name":name,"phone":phone,"address":address,"code":code,"o_takeSiteID":o_takeSiteID,"u_id":u_id},
			function(data){
				if(data=="true"){
					$(".m_right").empty();
					$(".m_right").load("../user/useraddress.jsp");
					$("#showInfo1").html("修改成功").css("color","green");
				}else{
					$("#showInfo1").html("修改失败").css("color","red");
				}
			},
			"json"
		);	
	}
	function deleteuseraddress(id1,id2){
		var o_takeSiteID = id1;
		var u_id = id2;
		$.post(
			"../Consignee_Info.do?opr=deleteuseraddress",
			{"o_takeSiteID":o_takeSiteID,"u_id":u_id},
			function(data){
				if(data=="true"){
					$(".m_right").empty();
					$(".m_right").load("../user/useraddress.jsp");
					$("#showInfo1").html("删除成功").css("color","green");
				}else{
					$("#showInfo1").html("删除失败").css("color","red");
				}
			},
			"json"
		);
	}
	
	function dodefaultadd(o_takeSiteID,u_id){
		$.post(
			"../Consignee_Info.do?opr=dodefaultadd",
			{"o_takeSiteID":o_takeSiteID,"u_id":u_id},
			function(data){
				if(data=="true"){
					$(".m_right").empty();
					$(".m_right").load("../user/useraddress.jsp");
				}
			},
			"json"
		);
	}
</script>
</head>
<body>
			<c:set var="users" value="${user}" scope="session"></c:set>
			<c:set var="Consignee_Infolist" value="${Consignee_InfoList}" scope="session"></c:set>
            <p></p>
            <div class="mem_tit">收货地址</div>
            <div id="useraddressinfoshow">
            	<c:forEach items="${Consignee_Infolist}" var="Consignee_Info">
            <div class="address">
            	<div class="a_close"><a onclick="deleteuseraddress(${Consignee_Info.o_takeSiteID},${users.u_id})"><img src="../images/a_close.png" /></a></div>
            	<table border="0" class="add_t" align="center" style="width:98%; margin:10px auto;" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right" width="80">收货人：</td>
                    <td>${Consignee_Info.o_name}</td>
                  </tr>
                  <tr>
                    <td align="right">配送区域：</td>
                    <td>${Consignee_Info.o_area}</td>
                  </tr>
                  <tr>
                    <td align="right">详细地址：</td>
                    <td>${Consignee_Info.o_add}</td>
                  </tr>
                  <tr>
                    <td align="right">手机：</td>
                    <td>${Consignee_Info.o_phone}</td>
                  </tr>
                  <tr>
                    <td align="right">邮政编码：</td>
                    <td>${Consignee_Info.o_code}</td>
                  </tr>
                </table>
				
                <p align="right">
                	<c:if test="${Consignee_Info.u_default_add==1}"><span style="color:green">默认地址</span></c:if>
        			<a onclick="dodefaultadd(${Consignee_Info.o_takeSiteID},${users.u_id})" style="color:#ff4e00;"><c:if test="${Consignee_Info.u_default_add==0}">设为默认</c:if></a>&nbsp; &nbsp; &nbsp; &nbsp; <a onclick="doupdateuseraddress(${Consignee_Info.o_takeSiteID})" style="color:#ff4e00;">编辑</a>&nbsp; &nbsp; &nbsp; &nbsp; 
                </p>

            </div> 
            </c:forEach>
            </div>
            
            <div class="mem_tit">
            	<a onclick="showaddress()"><img src="../images/add_ad.gif" /></a>
            </div>
            <div class="showaddress" style="display:none">
            <table border="0" class="add_tab" style="width:930px;"  cellspacing="0" cellpadding="0">
              <tr>
                <td width="135" align="right">配送地区</td>
                <td colspan="3" style="font-family:'宋体';">
     
                	<select class="jj" name="province">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="四川">四川</option>
                      <option value="重庆">重庆</option>
                      <option value="北京">北京</option>
                      <option value="云南">云南</option>
                    </select>
                    <select class="jj" name="city">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="成都">成都</option>
                      <option value="宜宾">宜宾</option>
                      <option value="南充">南充</option>
                      <option value="绵阳">绵阳</option>
                    </select>
                    <select class="jj" name="area">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="武侯区">武侯区</option>
                      <option value="成华区">成华区</option>
                      <option value="锦江区">锦江区</option>
                      <option value="青羊区">青羊区</option>
                    </select>
                    （必填）
                </td>
              </tr>
              <tr>
                <td align="right">收货人姓名</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="add_ipt" />（必填）</td>
                <td align="right">手机</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="add_ipt" />（必填）</td>
              </tr>
              <tr>
                <td align="right">详细地址</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="add_ipt" />（必填）</td>
                <td align="right">邮政编码</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="add_ipt" /></td>
              </tr>
            </table>
           	<p align="right">
            	<a onclick="notshowaddress()">取消</a>&nbsp; &nbsp; <a onclick="adduseraddresssuer(${users.u_id})" class="add_b">确认</a>
            </p> 
            </div>
            
            <div class="showupdateaddress" style="display:none">
            	<table border="0" class="add_tab" style="width:930px;"  cellspacing="0" cellpadding="0">
              <tr>
                <td width="135" align="right">配送地区</td>
                <td colspan="3" style="font-family:'宋体';">
                    	<input type="text" value="" class="update_ipt" >（必填）
                    	<input type="hidden" value="" id="RecordId">
                </td>
              </tr>
              <tr>
                <td align="right">收货人姓名</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="update_ipt" />（必填）</td>
                <td align="right">手机</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="update_ipt" />（必填）</td>
              </tr>
              <tr>
                <td align="right">详细地址</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="update_ipt" />（必填）</td>
                <td align="right">邮政编码</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="update_ipt" /></td>
              </tr>
            </table>
           	<p align="right">
            	<a onclick="notddoupdateuseraddress()">取消</a>&nbsp; &nbsp; <a onclick="suerdoupdateuseraddress(${users.u_id})" class="add_b">确认</a>
            </p> 
            </div>
            <p id="showInfo1" style="margin-left:400px;height:20px;font-size:25px"></p>
   
</body>
</html>