package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.Consignee_Information;
import com.sys.service.Consignee_InfoService;
import com.sys.serviceImpl.Consignee_InfoServiceImpl;
@WebServlet("/Consignee_Info.do")
public class Consignee_InfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Consignee_InfoService consignee_infoService = new Consignee_InfoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opr=req.getParameter("opr");
		switch (opr) {
		case "doupdateuseraddress":
			doupdateuseraddress(req,resp);
			break;
		case "adduseraddresssuer":
			adduseraddresssuer(req,resp);
			break;
		case "suerdoupdateuseraddress":
			suerdoupdateuseraddress(req,resp);
			break;
		case "deleteuseraddress":
			deleteuseraddress(req,resp);
			break;
		case "dodefaultadd":
			dodefaultadd(req,resp);
			break;
		case "showdefaultaddress":
			showdefaultaddress(req,resp);
			break;
		default:
			break;
		}
	}
	//购物车默认收货地址获取
	public void showdefaultaddress(HttpServletRequest req, HttpServletResponse resp){
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		List<Consignee_Information> consignee_infoList = consignee_infoService.getConsignee_InfoByU_Id(u_id);
		Consignee_Information consignee_infoList2 = new Consignee_Information();
		for(Consignee_Information c:consignee_infoList){
			if(c.getU_default_add()==1){
				consignee_infoList2 = c;
			}
		}
		req.getSession().setAttribute("u_defaultaddress",consignee_infoList2);
		try {
			PrintWriter out = resp.getWriter();
			out.write(JSON.toJSONString("true"));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//修改默认收货地址
	public void dodefaultadd(HttpServletRequest req, HttpServletResponse resp){
		int o_takeSiteID = Integer.parseInt(req.getParameter("o_takeSiteID"));
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		List<Consignee_Information> consignee_infoList = consignee_infoService.getConsignee_InfoByU_Id(u_id);
		for(Consignee_Information c:consignee_infoList){
			Consignee_Information c1 = new Consignee_Information();
			c1 = c;
			c1.setU_default_add(0);
			consignee_infoService.updateConsignee_Info(c1);	
		}
		Consignee_Information consignee_information = consignee_infoService.getConsignee_InfoById(o_takeSiteID);
		consignee_information.setU_default_add(1);
		try {
			PrintWriter out = resp.getWriter();
			if(consignee_infoService.updateConsignee_Info(consignee_information)){
				req.getSession().removeAttribute("Consignee_InfoList");
				List<Consignee_Information> consignee_infoList2 = consignee_infoService.getConsignee_InfoByU_Id(u_id);
				req.getSession().setAttribute("Consignee_InfoList",consignee_infoList2);
				out.write(JSON.toJSONString("true"));
			}else{
				out.write(JSON.toJSONString("false"));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//删除用户收货信息
	public void deleteuseraddress(HttpServletRequest req, HttpServletResponse resp){
		int o_takeSiteID = Integer.parseInt(req.getParameter("o_takeSiteID"));
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		try {
			PrintWriter out = resp.getWriter();
			if(consignee_infoService.delConsignee_Info(o_takeSiteID)){
				req.getSession().removeAttribute("Consignee_InfoList");
				List<Consignee_Information> consignee_infoList = consignee_infoService.getConsignee_InfoByU_Id(u_id);
				req.getSession().setAttribute("Consignee_InfoList",consignee_infoList);
				out.write(JSON.toJSONString("true"));
			}else{
				out.write(JSON.toJSONString("false"));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//修改收货信息
	public void suerdoupdateuseraddress(HttpServletRequest req, HttpServletResponse resp){
		String areas = req.getParameter("areas");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String code = req.getParameter("code");
		String o_takeSiteIDs = req.getParameter("o_takeSiteID");
		int o_takeSiteID = Integer.parseInt(o_takeSiteIDs);
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		Consignee_Information consignee_information = new Consignee_Information();
		consignee_information.setO_takeSiteID(o_takeSiteID);
		consignee_information.setO_area(areas);
		consignee_information.setO_name(name);
		consignee_information.setO_phone(phone);
		consignee_information.setO_add(address);
		consignee_information.setO_code(code);
		try {
			PrintWriter out = resp.getWriter();
			if(consignee_infoService.updateConsignee_Info(consignee_information)){
				req.getSession().removeAttribute("Consignee_InfoList");
				List<Consignee_Information> consignee_infoList = consignee_infoService.getConsignee_InfoByU_Id(u_id);
				req.getSession().setAttribute("Consignee_InfoList",consignee_infoList);
				out.write(JSON.toJSONString("true"));
			}else{
				out.write(JSON.toJSONString("false"));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//页面编辑请求
	public void doupdateuseraddress(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("o_takeSiteID");
		int o_takeSiteID = Integer.parseInt(id);
		Consignee_Information consignee_information = consignee_infoService.getConsignee_InfoById(o_takeSiteID);
		try {
			PrintWriter out = resp.getWriter();
			out.write(JSON.toJSONString(consignee_information));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//页面添加收货信息
	public void adduseraddresssuer(HttpServletRequest req, HttpServletResponse resp){
		String areas = req.getParameter("areas");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String code = req.getParameter("code");
		String u_ids = req.getParameter("u_id");
		int u_id = Integer.parseInt(u_ids);
		Consignee_Information consignee_information = new Consignee_Information();
		consignee_information.setU_id(u_id);
		consignee_information.setO_area(areas);
		consignee_information.setO_name(name);
		consignee_information.setO_phone(phone);
		consignee_information.setO_add(address);
		consignee_information.setO_code(code);
		try {
			PrintWriter out = resp.getWriter();
			if(consignee_infoService.addConsignee_Info(consignee_information)){
				req.getSession().removeAttribute("Consignee_InfoList");
				List<Consignee_Information> consignee_infoList = consignee_infoService.getConsignee_InfoByU_Id(u_id);
				req.getSession().setAttribute("Consignee_InfoList",consignee_infoList);
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
