<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="KeTangLianXi3.User,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//模拟后台数据
		List<User> list=new ArrayList<User>();
		list.add(new User(1001,"冻结用户","123456",0));//冻结用户
		list.add(new User(1002,"user","123456",1));//普通用户
		list.add(new User(1003,"admin","123456",2));//管理员
		//获取参数
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("userName");
		String password=request.getParameter("password");
		//判断用户是否选择了记住密码登录
		
		//判断角色
		User user=null;
		for(User users:list){
			if(name!=null&&name.equalsIgnoreCase(users.getName())){
				user=users;
				break;
			}
		}
		//判断登录
		if(user==null){//账号不存在
			session.setAttribute("loginfaild", "账号不存在");
			response.sendRedirect("loginfaild.jsp");
		}else {
			if(user.getPassword().equalsIgnoreCase(password)){//登录成功后
				//判断是否为冻结账号
				if(user.getSole()==0){
					session.setAttribute("loginfaild", "账号被冻结，请联系管理员");
					response.sendRedirect("loginfaild.jsp");
				}else{
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(30);
					//记录cookie
					//1.创建cookie //由于只能储存量小 值为字符串类型： 一般保存账号和密码~~
					String names=user.getName();
					String pwd=user.getPassword();
					Cookie cookieName=new Cookie("userName",names);
					Cookie cookiePwd=new Cookie("passeord",pwd);
					//2.添加cookie
					response.addCookie(cookieName);
					response.addCookie(cookiePwd);
					//3.获取cookie (因有多个cookie 获取的是数组 )
					Cookie[] cookies=request.getCookies();
					if(cookies!=null){
					//由于机制是现请求一次服务器后拿到 sessionid再客户端把sessionid存入客户端的Cookie中,
					//所有在第一次请求服务器是在客户端中并没有Cookie 也就是request.getCookies() 为空
						for(Cookie c:cookies){
							out.print(c.getName()+"=="+c.getValue());
						}
					}
					response.sendRedirect("index.jsp");
				}		
			}else{//密码错误
				session.setAttribute("loginfaild", "密码错误");
				response.sendRedirect("loginfaild.jsp");
			}
			
		}
		
	%>
</body>
</html>