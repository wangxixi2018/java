package com.sys.dao;

import java.util.List;

import com.sys.model.Order_Info;

public interface Order_InfoDao {
	//增加
	public int addO_Info(Order_Info order_info);
	//删除
	public int delOrder_Info(int o_InfoId);
	//修改
	public int updateOrder_Info(Order_Info order_info);
	//查询所有
	public List<Order_Info> findOrder_Info();
	//按条件查询
	public Order_Info findOrder_InfoById(int o_InfoId);
	public List<Order_Info> findOrder_InfoByOrder_Id(int orderId);
}
