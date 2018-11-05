package com.sys.service;

import java.util.List;

import com.sys.model.Order_Info;

public interface Order_InfoService {
	//增加
	public boolean addOrder_Info(Order_Info order_info);
	//删除
	public boolean delOrder_Info(int o_InfoId);
	//修改
	public boolean updateOrder_Info(Order_Info order_info);
	//查询
	public List<Order_Info> getOrder_Info();
	public Order_Info getOrder_InfoById(int o_InfoId);
	public List<Order_Info> getOrder_InfoByOrderId(int orderId);
}
