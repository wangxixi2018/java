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
	function gobalkonpag(){
		$(".content").remove();
		$(".i_bg").load("../buycar/orderBuy.jsp");
	}
	function dozfbbuygoods(orderId){
		$.post(
			"../order.do?opr=dozfbbuygoods",
			{"orderId":orderId},
			function(data){
				if(data=="true"){
					$(".btn_u").empty();
					$(".btn_u").append("<span style='color:green'>支付成功！！</span>");
				}
			},
			"json"
		);
	}
</script>
</head>
<body>
<c:set var="order_dobuys" value="${order_dobuy}" scope="session"></c:set>
<div class="content mar_20">
    	<img src="../images/img3.jpg" />        
    </div>
    
    <!--Begin 第三步：提交订单 Begin -->
    <div class="content mar_20">

<c:set var="not_sufficient_fund" value="${not_sufficient_funds}" scope="session"></c:set>      
<c:if test="${not empty not_sufficient_fund}">
	<!--Begin 余额不足 Begin -->
    	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr>
                <td>
                	<p style="font-size:22px;">提示 !</p>
                    <b style="color:#ff4e00; font-size:16px; font-family:'宋体';">您的余额不足以支付整个订单，请选择其他支付方式</b>
                	<div class="backs"><a href="javascript:gobalkonpag()">返回上一页</a></div>
                </td>
              </tr>
            </table>        	
        </div>
        <!--Begin 余额不足 Begin -->
</c:if>       
<c:if test="${empty not_sufficient_fund}">
	<c:if test="${order_dobuys.payment=='支付宝'}">
       <!--Begin 支付宝支付 Begin -->
    	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">${order_dobuys.order_number}</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	您选定的支付方式为: <font color="#ff4e00">支付宝</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${order_dobuys.o_money}</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	支付宝网站(www.alipay.com) 是国内先进的网上支付平台。<br />
                    支付宝收款接口：在线即可开通，零预付，免年费，单笔阶梯费率，无流量限制。<br />
                    <a href="#" style="color:#ff4e00;">立即在线申请</a>
                </td>
              </tr>
              <tr>
                <td>
                	<div class="btn_u" style="margin:0 auto; padding:0 20px; width:120px;"><a href="javascript:dozfbbuygoods(${order_dobuys.orderId})">立即使用支付宝支付</a></div>
                	<a href="../Index.jsp">首页</a> &nbsp; &nbsp; <a href="../user/user.jsp">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div>
        <!--Begin 支付宝支付 Begin -->
       </c:if>
	
		<c:if test="${order_dobuys.payment=='银行扣款/转账'}">
    	 <!--Begin 银行卡支付 Begin -->
    	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">${order_dobuys.order_number}</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	 您选定的支付方式为: <font color="#ff4e00">银行卡</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${order_dobuys.o_money}</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	银行名称 收款人信息：全称 ××× ；帐号或地址 ××× ；开户行 ×××。 <br />
                    注意事项：办理电汇时，请在电汇单“汇款用途”一栏处注明您的订单号。
                </td>
              </tr>
              <tr>
                <td>
                	<a href="../Index.jsp">首页</a> &nbsp; &nbsp; <a href="../user/user.jsp">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div>
        <!--Begin 银行卡支付 Begin -->
    	</c:if>
</c:if>     
   
    </div>
	<!--End 第三步：提交订单 End--> 
</body>
</html>