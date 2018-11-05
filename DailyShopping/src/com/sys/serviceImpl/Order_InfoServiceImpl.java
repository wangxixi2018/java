package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.Order_InfoDao;
import com.sys.daoImpl.Order_InfoDaoImpl;
import com.sys.model.Order_Info;
import com.sys.service.Order_InfoService;
import com.sys.util.JDBCUtil;

public class Order_InfoServiceImpl implements Order_InfoService{

	@Override
	public boolean addOrder_Info(Order_Info order_info) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Order_InfoDao order_infoDao = new Order_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			num = order_infoDao.addO_Info(order_info);
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
	public boolean delOrder_Info(int o_InfoId) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Order_InfoDao order_infoDao = new Order_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			num = order_infoDao.delOrder_Info(o_InfoId);
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
	public boolean updateOrder_Info(Order_Info order_info) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Order_InfoDao order_infoDao = new Order_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			num = order_infoDao.updateOrder_Info(order_info);
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
	public List<Order_Info> getOrder_Info() {
		Connection conn = null;
		List<Order_Info> list = new ArrayList<Order_Info>();
		try {
			conn = JDBCUtil.getConnection();
			Order_InfoDao order_infoDao = new Order_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			list = order_infoDao.findOrder_Info();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public Order_Info getOrder_InfoById(int o_InfoId) {
		Connection conn = null;
		Order_Info order_info = new Order_Info();
		try {
			conn = JDBCUtil.getConnection();
			Order_InfoDao order_infoDao = new Order_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			order_info = order_infoDao.findOrder_InfoById(o_InfoId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return order_info;
	}

	@Override
	public List<Order_Info> getOrder_InfoByOrderId(int orderId) {
		Connection conn = null;
		List<Order_Info> list = new ArrayList<Order_Info>();
		try {
			conn = JDBCUtil.getConnection();
			Order_InfoDao order_infoDao = new Order_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			list = order_infoDao.findOrder_InfoByOrder_Id(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

}
