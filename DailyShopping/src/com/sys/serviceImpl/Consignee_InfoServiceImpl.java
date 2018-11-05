package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.Consignee_InfoDao;
import com.sys.daoImpl.Consignee_InfoDaoImpl;
import com.sys.model.Consignee_Information;
import com.sys.service.Consignee_InfoService;
import com.sys.util.JDBCUtil;

public class Consignee_InfoServiceImpl implements Consignee_InfoService{

	@Override
	public boolean addConsignee_Info(Consignee_Information consignee_information) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Consignee_InfoDao consignee_infoDao = new Consignee_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			num = consignee_infoDao.addConsignee_Info(consignee_information);
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
	public boolean delConsignee_Info(int o_takeSiteID) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Consignee_InfoDao consignee_infoDao = new Consignee_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			num = consignee_infoDao.delConsignee_Info(o_takeSiteID);
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
	public boolean updateConsignee_Info(Consignee_Information consignee_information) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			Consignee_InfoDao consignee_infoDao = new Consignee_InfoDaoImpl(conn);
			conn.setAutoCommit(false);
			num = consignee_infoDao.updateConsignee_Info(consignee_information);
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
	public List<Consignee_Information> getAllConsignee_Info() {
		Connection conn = null;
		List<Consignee_Information> list = new ArrayList<Consignee_Information>();
		try {
			conn = JDBCUtil.getConnection();
			Consignee_InfoDao consignee_infoDao = new Consignee_InfoDaoImpl(conn);
			list = consignee_infoDao.findAllConsignee_Info();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<Consignee_Information> getConsignee_InfoByU_Id(int u_id) {
		Connection conn = null;
		List<Consignee_Information> list = new ArrayList<Consignee_Information>();
		try {
			conn = JDBCUtil.getConnection();
			Consignee_InfoDao consignee_infoDao = new Consignee_InfoDaoImpl(conn);
			list = consignee_infoDao.findConsignee_InfoByU_Id(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public Consignee_Information getConsignee_InfoById(int o_takeSiteID) {
		Connection conn = null;
		Consignee_Information consignee_information = new Consignee_Information();
		try {
			conn = JDBCUtil.getConnection();
			Consignee_InfoDao consignee_infoDao = new Consignee_InfoDaoImpl(conn);
			consignee_information = consignee_infoDao.fidConsignee_InfoById(o_takeSiteID);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return consignee_information;
	}

}
