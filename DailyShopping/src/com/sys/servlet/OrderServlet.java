package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.Goods;
import com.sys.model.Order_Info;
import com.sys.model.Orders;
import com.sys.model.S_Car;
import com.sys.model.User;
import com.sys.service.GoodsService;
import com.sys.service.OrderService;
import com.sys.service.Order_InfoService;
import com.sys.service.Order_statusService;
import com.sys.service.S_CarService;
import com.sys.service.UserService;
import com.sys.serviceImpl.GoodsServiceImpl;
import com.sys.serviceImpl.OrderServiceImpl;
import com.sys.serviceImpl.Order_InfoServiceImpl;
import com.sys.serviceImpl.Order_statusServiceImpl;
import com.sys.serviceImpl.S_CarServiceImpl;
import com.sys.serviceImpl.UserServiceImpl;
import com.sys.util.Do_Order_Number;
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderServiceImpl();
	private UserService userService = new UserServiceImpl();
	private S_CarService s_carService = new S_CarServiceImpl();
	private Order_statusService order_statusService = new Order_statusServiceImpl();
	private Order_InfoService order_infoService = new Order_InfoServiceImpl();
	private GoodsService goodsService = new GoodsServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opr = req.getParameter("opr");
		switch (opr) {
		case "addorders":
			addorders(req,resp);
			break;
		case "getorders":
			getorders(req,resp);
			break;
		case "dozfbbuygoods":
			dozfbbuygoods(req,resp);
			break;
		default:
			break;
		}
	}
	//支付宝支付
	public void dozfbbuygoods(HttpServletRequest req, HttpServletResponse resp){
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		Orders orders = orderService.getOrdersById(orderId);
		orders.setO_statusId(2);
		try {
			PrintWriter out = resp.getWriter();
			if(orderService.updateOrders(orders)){
				out.write(JSON.toJSONString("true"));
			}else{
				out.write(JSON.toJSONString("false"));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获得订单
	public void getorders(HttpServletRequest req, HttpServletResponse resp){
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		List<Orders> orderList = orderService.getOrdersByU_Id(u_id);
		List<Orders> orderList1 = new ArrayList<Orders>();
		for(Orders o:orderList){
			Orders order = new Orders();
			order = o;
			order.setO_status(order_statusService.getOrder_statusById(o.getO_statusId()).getO_statusName());
			orderList1.add(order);
		}
		req.getSession().setAttribute("orderList",orderList1);
		try {
			PrintWriter out = resp.getWriter();
			out.write(JSON.toJSONString("true"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加订单
	public void addorders(HttpServletRequest req, HttpServletResponse resp){
		boolean flag = false;
		int orderId2 = 0;
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		String money =req.getParameter("money");
		double money2 = Double.parseDouble(money);
		String payment = req.getParameter("payment");
		String name = req.getParameter("name");
		String add = req.getParameter("add");
		String phone = req.getParameter("phone");
		Orders orders = new Orders();
		orders.setU_id(u_id);
		orders.setO_money(money2);
		orders.setPayment(payment);
		orders.setO_statusId(1);
		orders.setO_add(add);
		orders.setO_name(name);
		orders.setO_phone(phone);
		String order_number = Do_Order_Number.getOrderNumber();
		orders.setOrder_number(order_number);
		if("余额支付".equals(payment)){
			User user = userService.getUserById(u_id);
			double u_money = user.getU_money();
			try {
				PrintWriter out = resp.getWriter();
				if(u_money<money2){
					out.write(JSON.toJSONString("false"));
					req.getSession().setAttribute("not_sufficient_funds","not_sufficient_funds");//余额不足
				}else{
					out.write(JSON.toJSONString("true"));
					req.getSession().removeAttribute("s_carList");
					flag = true;
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			req.getSession().removeAttribute("not_sufficient_funds");
			try {
				PrintWriter out = resp.getWriter();
				if(orderService.addOrders(orders)){
					int orderId = orderService.getOrderIdByOrder_number(order_number);
					orderId2 = orderId;
					flag = true;
					req.getSession().removeAttribute("s_carList");
					Orders order = new Orders();
					order.setOrder_number(order_number);
					order.setPayment(payment);
					order.setO_money(money2);
					order.setOrderId(orderId);
					req.getSession().setAttribute("order_dobuy",order);
					out.write(JSON.toJSONString("true"));
				}else{
					out.write(JSON.toJSONString("false"));
				}
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(flag){
			List<S_Car> list = s_carService.findS_CarByU_Id(u_id);
			for(S_Car s:list){
				Order_Info order_info = new Order_Info();
				order_info.setG_id(s.getG_id());
				order_info.setOrderId(orderId2);
				int count = s.getGoods_count(); 
				order_info.setO_count(count);
				order_info.setO_status(1);
				double price = 0.0;
				List<Goods> goodsList = goodsService.queryGoods(s.getG_id());
				for(Goods g:goodsList){
					price = g.getG_g_price();
				}
				order_info.setO_price(price);
				double totleprices = count*price;
				order_info.setO_totalprice(totleprices);
				order_infoService.addOrder_Info(order_info);
			}
			for(S_Car s:list){
				s_carService.delS_Car(s.getS_carId());
			}
		}
	}
}
