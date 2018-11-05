package com.sys.service;

import java.util.List;

import com.sys.model.Order_status;

public interface Order_statusService {
		//增加
		public boolean addOrder_status(Order_status o_status);
		//删除
		public boolean delOrder_status(int o_statusId);
		//修改
		public boolean updateOrder_status(Order_status o_status);
		//查询所有
		public List<Order_status> getOrder_status();
		//按条件查询
		public Order_status getOrder_statusById(int o_statusId);
}
