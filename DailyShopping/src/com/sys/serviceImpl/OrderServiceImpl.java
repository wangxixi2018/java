package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.OrdersDao;
import com.sys.daoImpl.OrdersDaoImpl;
import com.sys.model.Orders;
import com.sys.service.OrderService;
import com.sys.util.JDBCUtil;

public class OrderServiceImpl implements OrderService{

	@Override
	public boolean addOrders(Orders orders) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			num = ordersDao.addOrders(orders);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public boolean delOrders(int orderId) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			num = ordersDao.delOrders(orderId);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public boolean updateOrders(Orders orders) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			num = ordersDao.updateOrders(orders);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public List<Orders> getOrders() {
		Connection conn = null;
		List<Orders> list = new ArrayList<Orders>();
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			list = ordersDao.findOrders();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public Orders getOrdersById(int orderId) {
		Connection conn = null;
		Orders orders = new Orders();
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			orders = ordersDao.findOrdersById(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return orders;
	}

	@Override
	public List<Orders> getOrdersByU_Id(int u_id) {
		Connection conn = null;
		List<Orders> list = new ArrayList<Orders>();
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			list = ordersDao.findOrdersByU_Id(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public int getOrderIdByOrder_number(String order_number) {
		Connection conn = null;
		int num = 0;
		try {
			conn =JDBCUtil.getConnection();
			OrdersDao ordersDao = new OrdersDaoImpl(conn);
			num = ordersDao.findOrderIdByOrder_number(order_number);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return num;
	}

}
