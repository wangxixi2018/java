package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.G_sort2Dao;
import com.sys.daoImpl.G_sort2DaoImpl;
import com.sys.model.G_sort2;
import com.sys.service.G_sort2Service;
import com.sys.util.JDBCUtil;

public class G_sort2ServiceImpl implements G_sort2Service {

	@Override
	public int addG_sort2(String G_sort2) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort2Dao G_sort2Dao = new G_sort2DaoImpl(conn);
		int num = G_sort2Dao.addG_sort2(G_sort2);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delG_sort2(String G_sort2) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort2Dao G_sort2Dao = new G_sort2DaoImpl(conn);
		int num = G_sort2Dao.delG_sort2(G_sort2);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateG_sort2(int G_sort2ID, String G_sort2) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort2Dao G_sort2Dao = new G_sort2DaoImpl(conn);
		int num = G_sort2Dao.updateG_sort2(G_sort2ID, G_sort2);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<G_sort2> queryG_sort2() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sort2Dao G_sort2Dao = new G_sort2DaoImpl(conn);
		List<G_sort2> list = G_sort2Dao.queryG_sort2();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public G_sort2 getG_sort2ById(int g_sort2ID) {
		Connection conn = null;
		G_sort2 g_sort2 = new G_sort2();
		try {
			conn = JDBCUtil.getConnection();
			G_sort2Dao G_sort2Dao = new G_sort2DaoImpl(conn);
			g_sort2 = G_sort2Dao.getG_sort2ById(g_sort2ID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return g_sort2;
	}

}
