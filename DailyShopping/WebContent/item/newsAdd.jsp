<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<div style='margin-left:40px'>
<form method="post" action="../news.do?opr=addNews">
<label>主题</label><br>
<select name="n_sortId">
	<c:forEach items="${n_sortnames}" var="n_sortname">
	   <option value='${n_sortname.n_SortId }'>${n_sortname.n_SortName}</option>
	</c:forEach> 
</select><br>
标题<br>
<input type="text" name="n_title" size="15"><br>
内容<br>
<textarea  name="n_content" rows="10" cols="40"></textarea><br>
<input type="submit" value="确认提交">
</form>
</div>
</body>
</html>