package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.Consignee_Information;
import com.sys.model.G_Colors;
import com.sys.model.G_son;
import com.sys.model.Goods;
import com.sys.model.S_Car;
import com.sys.model.U_Limit;
import com.sys.model.U_Login;
import com.sys.model.User;
import com.sys.service.Consignee_InfoService;
import com.sys.service.G_ColorsService;
import com.sys.service.G_SizeService;
import com.sys.service.G_sonService;
import com.sys.service.G_sort1Service;
import com.sys.service.G_sort2Service;
import com.sys.service.GoodsService;
import com.sys.service.S_CarService;
import com.sys.service.U_LoginService;
import com.sys.service.UserService;
import com.sys.serviceImpl.Consignee_InfoServiceImpl;
import com.sys.serviceImpl.G_ColorsServiceImpl;
import com.sys.serviceImpl.G_SizeServiceImpl;
import com.sys.serviceImpl.G_sonServiceImpl;
import com.sys.serviceImpl.G_sort1ServiceImpl;
import com.sys.serviceImpl.G_sort2ServiceImpl;
import com.sys.serviceImpl.GoodsServiceImpl;
import com.sys.serviceImpl.S_CarServiceImpl;
import com.sys.serviceImpl.U_LoginServiceImpl;
import com.sys.serviceImpl.UserServiceImpl;
import com.sys.servlet.ImageCodeServlet;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private U_LoginService u_loginService = new  U_LoginServiceImpl();
	private Consignee_InfoService consignee_infoService = new Consignee_InfoServiceImpl();
	private S_CarService s_carService = new S_CarServiceImpl();
	private GoodsService goodsService = new GoodsServiceImpl();
	private G_sonService g_sonService = new G_sonServiceImpl();
	private G_sort1Service g_sort1Service = new G_sort1ServiceImpl();
	private G_sort2Service g_sort2Service = new G_sort2ServiceImpl();
	private G_ColorsService g_colorsService = new G_ColorsServiceImpl();
	private G_SizeService g_sizeService = new G_SizeServiceImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opr=req.getParameter("opr");
		if(opr!=null){
			switch (opr) {
			case "doUserName":
				doUserName(req,resp);
				break;
			case "doLogin":
				doLogin(req,resp);
				break;
			case "doyzm":
				doyzm(req,resp);
				break;
			case "addUser":
				addUser(req,resp);
				break;
			case "outLogin":
				outLogin(req,resp);
				break;
			case "updateUserInfo":
				updateUserInfo(req,resp);
				break;
			case "updateuserpassword":
				updateuserpassword(req,resp);
				break;
			default:
				break;
			}
		}
		
	}
	//用户修改密码验证
	public void updateuserpassword(HttpServletRequest req, HttpServletResponse resp){
		String oldpassword = req.getParameter("oldpassword");
		String newpassword = req.getParameter("newpassword");
		User user = (User)req.getSession().getAttribute("user");
		List<U_Login> list = u_loginService.findU_LoginByU_Id(user.getU_id());
		for(U_Login u:list){
			if(u.getU_LoginName().equals(user.getU_loginName())&&u.getU_LoginPwd().equals(oldpassword)){
				U_Login u_login = new U_Login();
				u_login.setU_LoginPwd(newpassword);
				u_login.setU_LoginID(u.getU_LoginID());
				try {
					PrintWriter out = resp.getWriter();
					if(u_loginService.updateU_login(u_login)){
						out.write(JSON.toJSONString("true"));
					}else{
						out.write(JSON.toJSONString("false"));
					}
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					PrintWriter out = resp.getWriter();
					out.write(JSON.toJSONString("pwdnoequals"));
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//用户信息修改
	public void updateUserInfo(HttpServletRequest req, HttpServletResponse resp){
		String username = req.getParameter("username");
		String userage = req.getParameter("userage");
		int u_age = Integer.parseInt(userage);
		String userphone = req.getParameter("userphone");
		String useremail = req.getParameter("useremail");
		String usercarid = req.getParameter("usercarid");
		String usersex = req.getParameter("usersex");
		String useraddress = req.getParameter("useraddress");
		User user = (User)req.getSession().getAttribute("user");
		int u_id = user.getU_id();
		User user2 = new User();
		user2 = user;
		user2.setU_realName(username);
		user2.setU_age(u_age);
		user2.setU_phone(userphone);
		user2.setU_email(useremail);
		user2.setU_papers(usercarid);
		user2.setU_sex(usersex);
		user2.setU_address(useraddress);
		user2.setShow_u_id(getShow_u_id(u_id));
		try {
			PrintWriter out =resp.getWriter();
			if(userService.updateUser(user2)){
				req.getSession().removeAttribute("user");
				req.getSession().setAttribute("user",user2);
				out.write(JSON.toJSONString(user2));
			}else{
				out.write(JSON.toJSONString(new User()));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//验证码验证
	public void doyzm(HttpServletRequest req, HttpServletResponse resp){
		String scyzm = ImageCodeServlet.ImageCode;
		String qtyzm = req.getParameter("yzmnum");
		String bool = "false";
		if(scyzm!=null && qtyzm!=null){
			if(scyzm.equalsIgnoreCase(qtyzm)){
				bool = "true";
			}else{
				bool ="false";
			}
		}
		try {
			PrintWriter out = resp.getWriter();
			out.write(bool);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//登陸驗證
	public void doLogin(HttpServletRequest req, HttpServletResponse resp){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		U_Login u_login = new U_Login();
		u_login.setU_LoginName(username);
		u_login.setU_LoginPwd(password);
		Object[] obj = userService.doLoging(u_login);
		User user1=userService.getUserById(userService.getU_IdByLoginName(username));
		if(obj[1]=="true"){
			User user = new User();
			user.setU_lastlogin_time(userService.getU_lastlogin_time(user1.getU_id()));
			user.setU_loginName(username);
			user.setU_nc(user1.getU_nc());
			user.setU_id(user1.getU_id());
			user.setU_sex(user1.getU_sex());
			user.setU_loginName(user1.getU_loginName());
			user.setU_realName(user1.getU_realName());
			int u_id=user1.getU_id();
			user.setShow_u_id(getShow_u_id(u_id));
			user.setU_email(user1.getU_email());
			user.setU_integral(user1.getU_integral());
			user.setU_papers(user1.getU_papers());
			user.setU_registration_time(user1.getU_registration_time());
			user.setU_phone(user1.getU_phone());
			user.setU_address(user1.getU_address());
			user.setU_path(user1.getU_path());
			user.setU_age(user1.getU_age());
			req.getSession().setAttribute("user", user);
			U_Limit u_limit = userService.getU_LimitByu_limit(user1.getU_limit());
			req.getSession().setAttribute("u_limit",u_limit);
			List<Consignee_Information> consignee_infoList = consignee_infoService.getConsignee_InfoByU_Id(u_id);
			req.getSession().setAttribute("Consignee_InfoList",consignee_infoList);
			List<S_Car> s_carList2 = new ArrayList<S_Car>();
			List<S_Car> s_carList = s_carService.findS_CarByU_Id(u_id);
			for(S_Car s:s_carList){
				S_Car s_car = new S_Car();
				s_car.setS_carId(s.getS_carId());
				s_car.setU_id(u_id);
				s_car.setGoods_count(s.getGoods_count());
				Goods goods = new Goods();
				s_car.setG_id(s.getG_id());
				List<Goods> goodsList = goodsService.queryGoods(s.getG_id());
				for(Goods g:goodsList){
					goods.setG_ID(g.getG_ID());
					goods.setG_sort1ID(g.getG_sort1ID());
					goods.setG_sort2ID(g.getG_sort2ID());
					goods.setG_sonID(g.getG_sonID());
					goods.setG_colorsID(g.getG_colorsID());
					goods.setG_sizeID(g.getG_sizeID());
					goods.setG_integral(g.getG_integral());
					goods.setG_g_price(g.getG_g_price());
					goods.setG_src(g.getG_src());
				}
				s_car.setG_integral(goods.getG_integral());
				s_car.setG_price(goods.getG_g_price());
				List<G_son> g_sonList = g_sonService.queryG_son(goods.getG_sonID());
				for(G_son g_son:g_sonList){
					s_car.setG_name(g_son.getG_sName());
				}
				s_car.setG_sortofsex(g_sort1Service.getG_sort1ById(goods.getG_sort1ID()).getG_sName());
				s_car.setG_sortofstyle(g_sort2Service.getG_sort2ById(goods.getG_sort2ID()).getG_sName());
				List<G_Colors> g_colorsList = g_colorsService.queryG_Colors(goods.getG_colorsID());
				for(G_Colors c:g_colorsList){
					s_car.setG_color(c.getG_colors());
				}
				s_car.setG_size(g_sizeService.getG_SizeById(goods.getG_sizeID()).getG_size());
				s_carList2.add(s_car);
			}
			req.getSession().setAttribute("s_carList",s_carList2);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("messages", obj[0]);
		map.put("booleans", obj[1]);
		try {
			PrintWriter out = resp.getWriter();
			out.write(JSON.toJSONString(map));
			out.close();
			userService.updateU_lastlogin_time(user1.getU_id());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//用户名验证
	public void doUserName(HttpServletRequest req, HttpServletResponse resp){
		String name = req.getParameter("name");
		String bool = "false";
		List<U_Login> list = u_loginService.findAllU_Login();
		for(U_Login u:list){
			if(u.getU_LoginName().equals(name)){
				bool="true";
				try {
					PrintWriter out = resp.getWriter();
					out.write(JSON.toJSONString(bool));
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}else{
				bool="false";
			}
		}
		try {
			PrintWriter out = resp.getWriter();
			out.write(JSON.toJSONString(bool));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//注册用户
	public void addUser(HttpServletRequest req, HttpServletResponse resp){
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		if(username!=null&&password!=null&&email!=null&&phoneNumber!=null){
			User user = new User();
			user.setU_email(email);
			user.setU_loginName(username);
			user.setU_loginPwd(password);
			user.setU_phone(phoneNumber);
			if(userService.addUser(user)){
				try {
					User user1 = userService.getUserByLoginName(username);
					user1.setShow_u_id(getShow_u_id(user1.getU_id()));
					User user2 = user1;
					U_Limit u_limit = userService.getU_LimitByu_limit(user1.getU_limit());
					req.getSession().setAttribute("user",user2);
					req.getSession().setAttribute("u_limit",u_limit);
					resp.sendRedirect("Index.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//用户id页面展示生产
	public String getShow_u_id(int u_id){
		int u_id1=u_id;
		String show_u_id ="";
		int count = 0;
		while(u_id>0){
			u_id/=10;
			count++;
		}
		if(count<8){
			for(int i=0;i<(9-count);i++){
				show_u_id+="0";
			}
			show_u_id+=""+u_id1;
		}
		return show_u_id;
	}
	//用户退出登陆时清除session
	public void outLogin(HttpServletRequest req, HttpServletResponse resp){
		req.getSession().invalidate();
		try {
			resp.sendRedirect("Login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
