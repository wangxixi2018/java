package com.sys.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys.model.User;
import com.sys.service.UserService;
import com.sys.serviceImpl.UserServiceImpl;
@WebServlet("/user.show")
public class UserShowPic extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从数据库获取图片的路劲（部署项目的根路径）此路劲必须包含到图片，
		User user = (User)request.getSession().getAttribute("user");
		String picpath = null;
		if(user != null && user instanceof User){
			picpath = userService.getU_picpathByU_id(user.getU_id());
		}
		//以该路劲创建一个新文件，只需要找到图片的路劲就可以
		File file = new File(picpath);
		response.setCharacterEncoding("gb2312");
		response.setContentType("image");
		response.setHeader("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("gb2312"),"iso8859-1"));

		OutputStream output = null;
		FileInputStream fis = null;
		try{
			output = response.getOutputStream();
			fis = new FileInputStream(file);
	
			byte[] b = new byte[1024];
			int i = 0;
	
			while((i = fis.read(b))!=-1){
				output.write(b, 0, i);
			}
			output.write(b, 0, b.length);
	
			output.flush();
			response.flushBuffer();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(fis != null){
				fis.close();
				fis = null;
			}if(output != null){
				output.close();
				output = null;
			}
		}
	}
	
}
