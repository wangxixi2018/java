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
</head>
<body>
<c:set var="users" value="${user}" scope="session"></c:set>
<c:set var="orderLists" value="${orderList}" scope="session"></c:set>
 <p></p>
            <div class="mem_tit">我的订单</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%">订单号</td>
                <td width="25%">下单时间</td>
                <td width="15%">订单总金额</td>
                <td width="15%">订单状态</td>
                <td width="25%">操作</td>
              </tr>
              <c:forEach items="${orderLists}" var="orderLists1">
               <tr>
                <td><font color="#ff4e00">${orderLists1.order_number}</font></td>
                <td>${orderLists1.order_Time}</td>
                <td>￥${orderLists1.o_money}</td>
                <td>${orderLists1.o_status}</td>
                <td><c:if test="${orderLists1.o_statusId>1}"><a style="color:green">确认收货</a></c:if><c:if test="${orderLists1.o_statusId==1}"><a style="color:red">支付订单</a></c:if>&nbsp;&nbsp;&nbsp;&nbsp;<a>取消订单</a></td>
              </tr>
              </c:forEach>
            </table>

</body>
</html>