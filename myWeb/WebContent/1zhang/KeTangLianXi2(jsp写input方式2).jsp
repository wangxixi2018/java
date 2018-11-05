<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,com.sys.model.Student,java.text.SimpleDateFormat,java.util.Date" %>
<%! List<Student> students=new ArrayList<Student>();
	SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日");
	Date date=new Date();
	StringBuffer str=new StringBuffer();	
%>
<%  students.add(new Student(13,"王子",20,'男',80,time.parse(time.format(date)))); //parse()把字符创类型的时间转化成Date
	students.add(new Student(14,"王王",25,'女',70,time.parse(time.format(date))));
	students.add(new Student(15,"王",25,'女',100,time.parse(time.format(date))));
	students.add(new Student(16,"王6",22,'女',90,time.parse(time.format(date))));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		
</script>
</head>
 <!-- 用jsp小脚本 拼接 -->
<body>
	<table border="1">
		<tr>	
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>分数</th>
			<th>入校时间</th>
			<th>操作</th>
		</tr>	
		<%
		/* 方法2： */
		for(int i=0;i<students.size();i++){
			str.append("<tr>");
			str.append("<td>"+students.get(i).getId()+"</td>");
			str.append("<td>"+students.get(i).getName()+"</td>");
			str.append("<td>"+students.get(i).getAge()+"</td>");
			str.append("<td>"+students.get(i).getSex()+"</td>");
			str.append("<td>"+students.get(i).getScore()+"</td>");
			str.append("<td>"+time.format(students.get(i).getDate())+"</td>");
			str.append("<td><a href='#'>修改</a>&nbsp;&nbsp;&nbsp;<a href='#'>删除</a></td>");
			str.append("</tr>");
			out.print(str);
		}
		%>
	</table>
</body>
</html>