<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


           <div id="yutp" class="yuop"> <%-- ${pageContext.request.contextPath}/file.dos   javascript:addGoods()--%>
		      <form action="${pageContext.request.contextPath}/file.dos" enctype="multipart/form-data" method="post"> 
				商品编号:<input type="text" size="1px"  name="g_ID" value="<%=request.getParameter("g_ID")!=null?request.getParameter("g_ID"):1%>"><br /><br>
				商品类型1：
				<select name="G_sort1ID" id="num1">
					<c:forEach items="${requestScope.listG_sort1}" var="u" varStatus="num">
		               <option>${ u.g_sort1ID} ${ u.g_sName}</option>
					</c:forEach>
				</select><br><br>
				商品类型2：
				<select name="G_sort2ID">
					<c:forEach items="${requestScope.listG_sort2}" var="u" varStatus="num">
		               <option>${ u.g_sort2ID} ${ u.g_sName}</option>
					</c:forEach>
				</select><br><br>
				商品品牌：
				<select name="g_sonID">
					<c:forEach items="${requestScope.listG_son}" var="u" varStatus="num">
		               <option>${ u.g_sonID} ${ u.g_sName}</option>
					</c:forEach>
				</select><br><br>
				选择颜色：
				<select name="g_colorsID">
					<c:forEach items="${requestScope.listG_Colors}" var="u" varStatus="num">
		               <option>${ u.g_colorsID} ${ u.g_colors}</option>
					</c:forEach>
				</select><br><br>
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

</html>
