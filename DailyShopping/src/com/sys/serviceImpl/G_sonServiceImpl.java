package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.G_sonDao;
import com.sys.daoImpl.G_sonDaoImpl;
import com.sys.model.G_son;
import com.sys.service.G_sonService;
import com.sys.util.JDBCUtil;

public class G_sonServiceImpl implements G_sonService {

	@Override
	public int addG_son(String G_son, String g_describe) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sonDao G_sonDao = new G_sonDaoImpl(conn);
		int num = G_sonDao.addG_son(G_son, g_describe);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delG_son(int g_sonID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sonDao G_sonDao = new G_sonDaoImpl(conn);
		int num = G_sonDao.delG_son(g_sonID);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateG_son(int G_sonID, G_son G_son) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sonDao G_sonDao = new G_sonDaoImpl(conn);
		int num = G_sonDao.updateG_son(G_sonID, G_son);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<G_son> queryG_son() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sonDao G_sonDao = new G_sonDaoImpl(conn);
		List<G_son> list = G_sonDao.queryG_son();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<G_son> queryG_son(int G_sonID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sonDao G_sonDao = new G_sonDaoImpl(conn);
		List<G_son> list = G_sonDao.queryG_son(G_sonID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

}
