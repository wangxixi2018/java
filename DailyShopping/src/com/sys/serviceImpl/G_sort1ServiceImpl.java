package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.G_sort1Dao;
import com.sys.daoImpl.G_sort1DaoImpl;
import com.sys.model.G_sort1;
import com.sys.service.G_sort1Service;
import com.sys.util.JDBCUtil;

public class G_sort1ServiceImpl implements G_sort1Service {

	@Override
	public int addG_sort1(String G_sort1) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort1Dao G_sort1Dao = new G_sort1DaoImpl(conn);
		int num = G_sort1Dao.addG_sort1(G_sort1);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delG_sort1(String G_sort1) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort1Dao G_sort1Dao = new G_sort1DaoImpl(conn);
		int num = G_sort1Dao.delG_sort1(G_sort1);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateG_sort1(int G_sort1ID, String G_sort1) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort1Dao G_sort1Dao = new G_sort1DaoImpl(conn);
		int num = G_sort1Dao.updateG_sort1(G_sort1ID, G_sort1);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<G_sort1> queryG_sort1() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort1Dao G_sort1Dao = new G_sort1DaoImpl(conn);
		List<G_sort1> list = G_sort1Dao.queryG_sort1();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public G_sort1 getG_sort1ById(int g_sort1ID) {
		Connection conn = null;
		G_sort1 g_sort1 = new G_sort1();
		try {
			conn = JDBCUtil.getConnection();
			G_sort1Dao G_sort1Dao = new G_sort1DaoImpl(conn);
			g_sort1 = G_sort1Dao.getG_sort1ById(g_sort1ID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return g_sort1;
	}

}
