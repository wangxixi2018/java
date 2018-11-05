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
   <div id="yutp" class="yuop">
     <form action="${pageContext.request.contextPath}/file.dos" enctype="multipart/form-data" method="post"> 
     <%-- 	<p>
        <label> 商品类型1 </label>
        <select name="G_sort1ID">
          <c:forEach items="${requestScope.topics}" var="topic">
            <c:choose>
              <c:when test="${news.ntid == topic.tid}">
                <option value='${topic.tid}' selected="selected">${topic.tname}</option></c:when>
              <c:otherwise><option value='${topic.tid}'>${topic.tname}</option></c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
      </p> --%>
	<p>
	  <label> 商品类型1 </label>
		<select name="G_sort1ID">
			<c:forEach items="${requestScope.listG_sort1}" var="G_sort1" varStatus="num">
			  <c:forEach items="${requestScope.listGoods}" var="Goods" varStatus="num">
			  	<c:set var="roles" value="${Goods.g_sort1ID}"></c:set>
			  </c:forEach>
			 <c:choose>
	              <c:when test="${G_sort1.g_sort1ID == roles}">
	              	 <option value='${G_sort1.g_sort1ID}' selected="selected">${G_sort1.g_sName}</option>
	              </c:when>
            <c:otherwise>
            	<c:set var="role" value="${G_sort1.g_sort1ID}"></c:set>
				<c:choose>
					<c:when test="${role ==1 }">
						<option value='${G_sort1.g_sort1ID}'>男装</option>
					</c:when>
					<c:when test="${role ==2 }">
						<option value='${G_sort1.g_sort1ID}'>女装</option>
					</c:when>
					<c:when test="${role ==3 }">
						<option value='${G_sort1.g_sort1ID}'>童装</option>
					</c:when>
					<c:when test="${role ==4 }">
						<option value='${G_sort1.g_sort1ID}'>老年装</option>
					</c:when>
				</c:choose>  		 
           	</c:otherwise>
           </c:choose>        
		</c:forEach>
	  </select>	
   </p><br/> 
   	<p>
	  <label> 商品类型2 </label>
		<select name="G_sort2ID">
			<c:forEach items="${requestScope.listG_sort2}" var="G_sort2" varStatus="num">
			  <c:forEach items="${requestScope.listGoods}" var="Goods" varStatus="num">
			  	<c:set var="roles" value="${Goods.g_sort2ID}"></c:set>
			  </c:forEach>
			 <c:choose>
	              <c:when test="${G_sort2.g_sort2ID == roles}">
	              	 <option value='${G_sort2.g_sort2ID}' selected="selected">${G_sort2.g_sName}</option>
	              </c:when>
            <c:otherwise>
            	<c:set var="role" value="${G_sort2.g_sort2ID}"></c:set>
				<c:choose>
					<c:when test="${role ==1 }">
						<option value='${G_sort2.g_sort2ID}'>外套</option>
					</c:when>
					<c:when test="${role ==2 }">
						<option value='${G_sort2.g_sort2ID}'>T恤</option>
					</c:when>
					<c:when test="${role ==3 }">
						<option value='${G_sort2.g_sort2ID}'>衬衣</option>
					</c:when>
					<c:when test="${role ==4 }">
						<option value='${G_sort2.g_sort2ID}'>长裤</option>
					</c:when>
					<c:when test="${role ==5 }">
						<option value='${G_sort2.g_sort2ID}'>牛仔裤</option>
					</c:when>
				</c:choose>  		 
           	</c:otherwise>
           </c:choose>        
		</c:forEach>
	  </select>	
   </p><br/>
   <p>
	  <label> 商品品牌 </label>
		<select name="G_sonID">
			<c:forEach items="${requestScope.listG_son}" var="G_son" varStatus="num">
			  <c:forEach items="${requestScope.listGoods}" var="Goods" varStatus="num">
			  	<c:set var="roles" value="${Goods.g_sonID}"></c:set>
			  </c:forEach>
			 <c:choose>
	              <c:when test="${G_son.g_sonID == roles}">
	              	 <option value='${G_son.g_sonID}' selected="selected">${G_son.g_sName}</option>
	              </c:when>
            <c:otherwise>
            	<c:set var="role" value="${G_son.g_sonID}"></c:set>
				<c:choose>
					<c:when test="${role ==1 }">
						<option value='${G_son.g_sonID}'>雅鹿</option>
					</c:when>
					<c:when test="${role ==2 }">
						<option value='${G_son.g_sonID}'>南极人</option>
					</c:when>
					<c:when test="${role ==3 }">
						<option value='${G_son.g_sonID}'>红豆男装</option>
					</c:when>
					<c:when test="${role ==4 }">
						<option value='${G_son.g_sonID}'>花花公子</option>
					</c:when>
					<c:when test="${role ==5 }">
						<option value='${G_son.g_sonID}'>罗蒙</option>
					</c:when>
					<c:when test="${role ==6 }">
						<option value='${G_son.g_sonID}'>七匹狼</option>
					</c:when>
					<c:when test="${role ==7 }">
						<option value='${G_son.g_sonID}'>美特斯邦威</option>
					</c:when>
					<c:when test="${role ==8 }">
						<option value='${G_son.g_sonID}'>美国苹果</option>
					</c:when>
					<c:when test="${role ==9 }">
						<option value='${G_son.g_sonID}'>四川拍拍衣</option>
					</c:when>
					<c:when test="${role ==10 }">
						<option value='${G_son.g_sonID}'>才子男装</option>
					</c:when>
					<c:when test="${role ==11 }">
						<option value='${G_son.g_sonID}'>鼎度</option>
					</c:when>
					<c:when test="${role ==12 }">
						<option value='${G_son.g_sonID}'>尊尚鸟</option>
					</c:when>
				</c:choose>  		 
           	</c:otherwise>
           </c:choose>        
		</c:forEach>
	  </select>	
   </p><br/>
   
   
   <p>
   	<label> 选择颜色 </label>
		<select name="g_colorsID">
			<c:forEach items="${requestScope.listG_Colors}" var="G_Colors" varStatus="num">
			  <c:forEach items="${requestScope.listGoods}" var="Goods" varStatus="num">
			  	<c:set var="roles" value="${Goods.g_colorsID}"></c:set>
			  </c:forEach>
			 <c:choose>
	              <c:when test="${G_Colors.g_colorsID == roles}">
	              	 <option value='${G_Colors.g_colorsID }' selected="selected">${G_Colors.g_colors}</option>
	              </c:when>
            <c:otherwise>
            	<c:set var="role" value="${G_Colors.g_colorsID}"></c:set>
				<c:choose>
					<c:when test="${role ==1 }">
						<option value='${G_Colors.g_colorsID}'>红色</option>
					</c:when>
					<c:when test="${role ==2 }">
						<option value='${G_Colors.g_colorsID}'>白色</option>
					</c:when>
					<c:when test="${role ==3 }">
						<option value='${G_Colors.g_colorsID}'>黑色</option>
					</c:when>
					<c:when test="${role ==4 }">
						<option value='${G_Colors.g_colorsID}'>灰色</option>
					</c:when>
					<c:when test="${role ==5 }">
						<option value='${G_Colors.g_colorsID}'>蓝色</option>
					</c:when>
					<c:when test="${role ==6 }">
						<option value='${G_Colors.g_colorsID}'>绿色</option>
					</c:when>
				</c:choose>  		 
           	</c:otherwise>
           </c:choose>        
		</c:forEach>
	  </select>
   </p><br/>
		选择规格尺码：
		<select  name="g_sizeID">
			<c:forEach items="${requestScope.listG_Size}" var="u" varStatus="num">
              <option>${ u.g_sizeID} ${ u.g_size}</option>
			</c:forEach>
		</select><br><br>
		商品展示区域:
		<select name="g_rankID">	
			<c:forEach items="${requestScope.listG_rank}" var="u" varStatus="num">
              <option>${ u.g_rankID} ${ u.g_rankname}</option>
			</c:forEach>
		</select><br><br>
		商品卖价：<input type="text" size="1px" name="g_g_price"><br /><br>
		商品积分：<input type="text" size="1px" name="g_integral"><br /><br>
		上传文件：<input type="file" name="g_src"><br /><br>
		<input type="submit" value="提交"> 
</form>      
        </div>
</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
