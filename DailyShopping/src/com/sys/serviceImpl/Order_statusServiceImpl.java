package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.Order_statusDao;
import com.sys.daoImpl.Order_statusDaoImpl;
import com.sys.model.Order_status;
import com.sys.service.Order_statusService;
import com.sys.util.JDBCUtil;

public class Order_statusServiceImpl implements Order_statusService{

	@Override
	public boolean addOrder_status(Order_status o_status) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Order_statusDao o_statusDao = new Order_statusDaoImpl(conn);
			conn.setAutoCommit(false);
			num = o_statusDao.addOrder_status(o_status);
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
	public boolean delOrder_status(int o_statusId) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Order_statusDao o_statusDao = new Order_statusDaoImpl(conn);
			conn.setAutoCommit(false);
			num = o_statusDao.delOrder_status(o_statusId);
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
	public boolean updateOrder_status(Order_status o_status) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Order_statusDao o_statusDao = new Order_statusDaoImpl(conn);
			conn.setAutoCommit(false);
			num = o_statusDao.updateOrder_status(o_status);
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
	public List<Order_status> getOrder_status() {
		Connection conn = null;
		List<Order_status> list = new ArrayList<Order_status>();
		try {
			conn = JDBCUtil.getConnection();
			Order_statusDao o_statusDao = new Order_statusDaoImpl(conn);
			list = o_statusDao.findOrder_status();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}	
		return list;
	}

	@Override
	public Order_status getOrder_statusById(int o_statusId) {
		Connection conn = null;
		Order_status o_status = new Order_status();
		try {
			conn = JDBCUtil.getConnection();
			Order_statusDao o_statusDao = new Order_statusDaoImpl(conn);
			o_status = o_statusDao.findOrder_statusById(o_statusId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}	
		return o_status;
	}

	
}
