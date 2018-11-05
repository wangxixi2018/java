<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%	//post 方式提交
		request.setCharacterEncoding("utf-8");//获取前修改编码格式
		String name=request.getParameter("userName");//获取表单组件名称提交的数据
		//name=new String(name.getBytes("ISO-8859-1"),"utf-8"); get方式提交
		String password=request.getParameter("password");//获取表单组件名称提交的数据
		String[]checkbox=request.getParameterValues("checkboxs");//获取表单组件名称相同提交的一组数据
	%>
