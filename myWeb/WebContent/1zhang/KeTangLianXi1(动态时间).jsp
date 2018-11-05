<%@page import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String time(){
		SimpleDateFormat timp=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//创建时间器（输入指定格式）
		Date date=new Date();//创建时间对象
		String time=timp.format(date);//把Date 对象生成的时间转化成 String
	return time;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#now{
		font-size: 30px;
	}
</style>
<!-- 让时间动态 -->
<!-- 方法1：纯js  采用一次刷新自己调用自己方式   ：setTimeout()  不要使用周期刷新时间方式 ：setInterval()   会不能的刷新--> 
<script type="text/javascript">
	window.onload=function () {	
		//tims(); //让setTimeout 调动刷新方法
		timeo();
		setTimeout(tims,1000);
	}
	  function timeo(){  
		 document.getElementById("now").innerHTML="<%=time()%>";  
		 //setInterval(timeo,1000);
	  }
	   function tims(){ 
		   window.location.reload();   
	  }  
</script>
</head>
<body>

<span>当前时间为：<span id='now'>2018-08-01 12:12:15</span></span>
</body>
</html>
<!-- 方法2：jsp+js -->
<%--  <%
	while(true){
%>
<script type="text/javascript">
	var num=document.getElementById("now");
	num.innerHTML="<%=time()%>"

</script>
<%
	}
%> --%>