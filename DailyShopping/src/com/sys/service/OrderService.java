package com.sys.service;

import java.util.List;

import com.sys.model.Orders;

public interface OrderService {
	//增加
		public boolean addOrders(Orders orders);
		//删除
		public boolean delOrders(int orderId);
		//修改
		public boolean updateOrders(Orders orders);
		//查询所有
		public List<Orders> getOrders();
		//按条件查询
		public Orders getOrdersById(int orderId);
		public List<Orders> getOrdersByU_Id(int u_id);
		public int getOrderIdByOrder_number(String order_number);
}
