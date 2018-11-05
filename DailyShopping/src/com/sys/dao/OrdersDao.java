package com.sys.dao;

import java.util.List;

import com.sys.model.Orders;
//订单总表
public interface OrdersDao {
	//增加
	public int addOrders(Orders orders);
	//删除
	public int delOrders(int orderId);
	//修改
	public int updateOrders(Orders orders);
	//查询所有
	public List<Orders> findOrders();
	//按条件查询
	public Orders findOrdersById(int orderId);
	public List<Orders> findOrdersByU_Id(int u_id);
	public int findOrderIdByOrder_number(String order_number);
}
