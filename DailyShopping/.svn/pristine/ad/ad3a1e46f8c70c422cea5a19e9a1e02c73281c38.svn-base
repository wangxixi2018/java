package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.User;
import com.sys.service.UserService;
import com.sys.serviceImpl.UserServiceImpl;
@WebServlet("/user.do")
public class UserServlet extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opr=req.getParameter("opr");
		System.out.println(opr);
		if(opr!=null){
			switch (opr) {
			case "doUserName":
				doUserName(req,resp);
				break;

			default:
				break;
			}
		}
		
	}
	//用户名验证
	public void doUserName(HttpServletRequest req, HttpServletResponse resp){
		String username = req.getParameter("name");
		System.out.println(username);
		User u = new User();
		u.setU_loginName(username);
		User user = userService.getLogin(u);
		try {
			PrintWriter out=resp.getWriter();
			if(user!=null){
				out.write(JSON.toJSONString("true"));
			}else{
				out.write(JSON.toJSONString("false"));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
