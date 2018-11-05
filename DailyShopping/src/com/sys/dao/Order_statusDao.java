package com.sys.dao;

import java.util.List;

import com.sys.model.Order_status;

//订单状态
public interface Order_statusDao {
	//增加
	public int addOrder_status(Order_status o_status);
	//删除
	public int delOrder_status(int o_statusId);
	//修改
	public int updateOrder_status(Order_status o_status);
	//查询所有
	public List<Order_status> findOrder_status();
	//按条件查询
	public Order_status findOrder_statusById(int o_statusId);
}
