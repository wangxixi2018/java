package com.sys.dao;

import java.sql.SQLException;
import java.util.List;

import com.sys.model.Orders;

public interface OrdersDao {
    //通过订单id添加订单
	public int addOders(Orders orders) throws SQLException; 
	//通过订单id删除订单
	public int delOders(int orderID) throws SQLException; 
	//通过订单id修改订单
	public int updateOders(Orders orders) throws SQLException;
	//查询所有订单
	public List<Orders> getAllOders() throws SQLException;
	//通过id查询相应订单信息
	public Orders getOrdersInfo(int orderID) throws SQLException;
}
