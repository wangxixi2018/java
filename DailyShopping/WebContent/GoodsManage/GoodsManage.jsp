<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
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
        
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/menu.js"></script>    
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>
	
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/GoodsManage.js"></script>
        
    
<title>商品管理</title>
</head>
<body id="body">  
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
                    <td width="115"><img src="../images/user.jpg" width="90" height="90" /></td>
                    <td>
                    	<div class="m_user">TRACY</div>          
                    </td>
                  </tr>
                </table>	
            </div>  
            <%
				Cookie[] cookie=request.getCookies();
            /* 	for(int i=0;i<cookie.length;i++){
            		out.print(cookie[i].getMaxAge());
            	} */
            	%>
            	<br/>
            	<%
            	//out.print(cookie==null);
            	//out.println(cookie.length); // 通过  cookie的长度来判断值       
            	//cookie==null||cookie.length==1?0:1   如果服务器第一次加载时没有 cookie==null  而只有cookie.length的判断是会爆出错误的
            %>
            <input  id="opol" type="hidden" name="opr" value="<%=cookie==null||cookie.length==1?0:1%>" />
            <div id="yutp" class="yuop"></div>  
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
