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
<script type="text/javascript" src="${pageContext.request.contextPath}/buycar/buycar_js/orderbuy.js"></script>
</head>
<body>
<c:set var="users" value="${user}" scope="session"></c:set>
<input type="hidden" id="do_u_id" value="${users.u_id}">
<div class="content mar_20">
    	<img src="../images/img2.jpg" />        
    </div>
<!--Begin 第二步：确认订单信息 Begin -->
    <div class="content mar_20">
    	<div class="two_bg">
        	<div class="two_t">
            	<span class="fr"><a href="#"></a></span>商品列表
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="550">商品名称</td>
                <td class="car_th" width="140">属性</td>
                <td class="car_th" width="150">购买数量</td>
                <td class="car_th" width="130">单价</td>
                <td class="car_th" width="140">返还积分</td>
              </tr>
              <c:forEach items="${s_carList}" var="s_carLists">
              <tr>
                <td>
                    <div class="c_s_img"><img src="../images/c_1.jpg" width="73" height="73" /></div>
                    ${s_carLists.g_name}  ${s_carLists.g_sortofsex }  ${s_carLists.g_sortofstyle}
                </td>
                <td align="center"><p>尺码:${s_carLists.g_size}</p>颜色:${s_carLists.g_color}</td>
                <td align="center"><span class="count2">${s_carLists.goods_count}</span></td>
                <td align="center" style="color:#ff4e00;">￥<span class="price2">${s_carLists.g_price}</span></td>
                <td align="center"><span class="integral2">${s_carLists.g_integral}</span>R</td>
              </tr>
              </c:forEach>
            
              <tr>
                <td colspan="5" align="right" style="font-family:'Microsoft YaHei';">
                    商品总价：￥<span id="showgoodsprices1"></span> ； 返还积分 <span id="showthisjifen"></span>R  
                </td>
              </tr>
            </table>
            <c:set var="u_defaultaddress2" value="${u_defaultaddress}" scope="session"></c:set>
            <div class="two_t">
            	<span class="fr"><a href="#"></a></span>收货人信息
            </div>
            <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="p_td" width="160">收货人姓名</td>
                <td width="395"><input type="text" class="takeinfo" value="${u_defaultaddress2.o_name}"></td>
                <td class="p_td" width="160">收货人电话</td>
                <td width="395"><input type="text" class="takeinfo" value="${u_defaultaddress2.o_phone}"></td>
              </tr>
              <tr>
                <td class="p_td">收货区域</td>
                <td><input type="text" class="takeinfo" value="${u_defaultaddress2.o_area}"></td>
                <td class="p_td">详细地址</td>
                <td><input type="text" style="width:380" class="takeinfo" value="${u_defaultaddress2.o_add}"></td>
              </tr>
              
            </table>

            <div class="two_t">
            	支付方式
            </div>
            <ul class="pay">
                <li class="checked" id="pay_do1">余额支付<div class="ch_img"></div></li>
                <li id="pay_do2">银行扣款/转账<div class="ch_img"></div></li>
                <li id="pay_do3">支付宝<div class="ch_img"></div></li>
            </ul>
  
            <table border="0" style="width:900px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right">
                	该订单完成后，您将获得 <font color="#ff4e00"><span id="showthisjifen2"></span></font> 积分  <br />
                    商品总价: <font color="#ff4e00">￥<span id="showgoodsprices2"></span></font>
                </td>
              </tr>
              <tr height="70">
                <td align="right">
                	<b style="font-size:14px;">应付款金额：<span style="font-size:22px; color:#ff4e00;">￥<span id="showgoodsprices3"></span></span></b>
                </td>
              </tr>
              <tr height="70">
                <td align="right"><a href="javascript:suerbuygoods()"><img src="../images/btn_sure.gif" /></a></td>
              </tr>
            </table>

            
        	
        </div>
    </div>
	<!--End 第二步：确认订单信息 End-->
</body>
</html>