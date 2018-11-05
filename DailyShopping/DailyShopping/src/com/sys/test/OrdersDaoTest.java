package com.sys.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.sys.dao.OrdersDao;
import com.sys.daoImpl.OrdersDaoImpl;
import com.sys.model.Orders;
import com.sys.util.JDBCUtil;

public class OrdersDaoTest {

	public static void main(String[] args) {
		//增加订单测试
		Connection conn=null;
		try {
			conn=JDBCUtil.getConnection();
			OrdersDao ordersDao=new OrdersDaoImpl(conn);
			int orderID= 1;
			int o_InfoID=1;
			int o_statusID=1;
			int u_ID =1;
			String o_beginTime="2018-6-5";
			Double o_money=20.00;
			String o_add="四川省成都市武侯区";
			String o_name="张三";
			String o_phone="13578948946";
			Orders orders=new Orders();
			orders.setOrderID(orderID);
			orders.setO_InfoID(o_InfoID);
			orders.setO_statusID(o_statusID);
			orders.setU_ID(u_ID);
			orders.setO_beginTime(o_beginTime);
			orders.setO_money(o_money);
			orders.setO_add(o_add);
			orders.setO_name(o_name);
			orders.setO_phone(o_phone);
			int num=ordersDao.addOders(orders);
			if(num==0) {
				System.out.println("添加订单失败");
			}else {
				System.out.println("添加订单成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//删除订单测试
		//修改订单测试
		//查询订单测试
	}

}
