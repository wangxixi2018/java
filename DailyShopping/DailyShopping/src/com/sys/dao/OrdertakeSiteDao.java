package com.sys.dao;

import java.sql.SQLException;
import java.util.List;

import com.sys.model.OrdertakeSite;

public interface OrdertakeSiteDao {
     //增加订单收获地址
	public int addOrdertakeSite(OrdertakeSite ordertakesite) throws SQLException; 
	 //删除订单收获地址
	public int delOrdertakeSite(int o_takeSiteID) throws SQLException;
	 //修改订单收获地址
	public int updateOrdertakeSite(OrdertakeSite ordertakesite) throws SQLException; 
	 //查询订单收获地址
	public List<OrdertakeSite> getAllOrdertakeSite() throws SQLException;
}
