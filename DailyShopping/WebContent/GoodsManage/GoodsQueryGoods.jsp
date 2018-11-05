<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>    
        
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/GoodsManage.js"></script>
        
    
<title>商品管理</title>
</head>
<body>  
 
<!--Begin Header Begin-->
<!-- 头部 -->
<%@ include file="GoodsManageHead.jsp" %>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
         <!-- 左部 -->
         <%@ include file="GoodsManageleft.jsp" %>
		<div class="m_right">
        	<div class="m_des">
            	<table border="0" style="width:870px; line-height:22px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td width="115"><img src="${pageContext.request.contextPath}/images/user.jpg" width="90" height="90" /></td>
                    <td>
                    	<div class="m_user">TRACY</div>          
                    </td>
                  </tr>
                </table>	
            </div>  
            <div id="toopd">
            	<input type="hidden" name="opr" value="${requestScope.listGoods}" />
            	
            	
            	<table border="1" cellpadding="15px" cellspacing="0" align="center">
            		<%-- <thead>
            			 <tr>
					        <td>商品图片</td>
					        <td>序号</td>
					        <td>商品类型</td>
					        <td>商品类别</td>
					        <td>商品品牌</td>
					        <td>商品价格</td>
					        <td>商品积分</td>
					        <td>商品修改</td>
						  </tr>
					</thead>
					<c:forEach items="${requestScope.listGoods}" var="num" varStatus="nums">
						 <tr>
					        <td><img  src="downFile.do?opr=${num.g_ID}" width="60"/></td>
					        <td>${nums.count}<input type="hidden" name="opr" value="${num.g_ID}" /></td>
					        <td>
					        	<c:if test="${not empty num.g_sort1ID}">
					        		<c:set var="role" value="${num.g_sort1ID }" scope="page"></c:set>
					        		<c:choose>
										<c:when test="${role ==1 }">
										男装	
										</c:when>
										<c:when test="${role ==2 }">
											女装
										</c:when>
										<c:when test="${role ==3 }">
											童装
										</c:when>
										<c:when test="${role ==4 }">
											老年装
										</c:when>	
										<c:otherwise>
										 	无名氏
										</c:otherwise>
									</c:choose>
					        	</c:if>
					        </td>
					        <td>
					        	<c:if test="${not empty num.g_sort2ID}">
					        		<c:set var="role" value="${num.g_sort2ID }" scope="page"></c:set>
					        		<c:choose>
										<c:when test="${role ==1 }">
											外套
										</c:when>
										<c:when test="${role ==2 }">
											T恤
										</c:when>
										<c:when test="${role ==3 }">
											衬衣
										</c:when>
										<c:when test="${role ==4 }">
											长裤
										</c:when>	
										<c:when test="${role ==5 }">
											牛仔裤
										</c:when>	
										<c:otherwise>
										 	无名氏
										</c:otherwise>
									</c:choose>
					        	</c:if>
					        </td>
					        <td>
					        	<c:if test="${not empty num.g_sonID}">
					        		<c:set var="roles" value="${num.g_sonID}" scope="page"></c:set>
					        		<c:choose>
										<c:when test="${roles ==1 }">
											雅鹿
										</c:when>
										<c:when test="${roles ==2 }">
											南极人
										</c:when>
										<c:when test="${roles ==3 }">
											红豆男装
										</c:when>
										<c:when test="${roles ==4 }">
											花花公子
										</c:when>	
										<c:when test="${roles ==5 }">
											罗蒙
										</c:when>	
										<c:when test="${roles ==6 }">
											七匹狼
										</c:when>
										<c:when test="${roles ==7 }">
											美特斯邦威
										</c:when>
										<c:when test="${roles ==8 }">
											美国苹果
										</c:when>
										<c:when test="${roles ==9 }">
											四川拍拍衣
										</c:when>	
										<c:when test="${roles ==10 }">
											才子男装
										</c:when>	
										<c:when test="${roles ==11}">
											鼎度
										</c:when>
										<c:when test="${roles ==12 }">
											尊尚鸟
										</c:when>
										<c:otherwise>
										 	无名氏
										</c:otherwise>
									</c:choose>
					        	</c:if>
						     </td>
					        <td>${num.g_g_price}</td>
					        <td>${num.g_integral}</td>
					        <td><a>修改</a></td>
					        <td><a>删除</a></td>
						  </tr>
					</c:forEach>--%>
				</table> 
				
				
				
            </div>
              
        </div>
</div>	
    
    <!--  尾部 -->
    <%@ include file="GoodsManagetail.jsp" %>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
