package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.G_rankDao;
import com.sys.daoImpl.G_rankDaoImpl;
import com.sys.model.G_rank;
import com.sys.service.G_rankService;
import com.sys.util.JDBCUtil;

public class G_rankServiceImpl implements G_rankService {

	@Override
	public int addG_rank(String G_rank) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_rankDao G_rankDao = new G_rankDaoImpl(conn);
		int num = G_rankDao.addG_rank(G_rank);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delG_rank(String g_rankname) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_rankDao G_rankDao = new G_rankDaoImpl(conn);
		int num = G_rankDao.delG_rank(g_rankname);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateG_rank(int G_rankID, String g_rankname) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_rankDao G_rankDao = new G_rankDaoImpl(conn);
		int num = G_rankDao.updateG_rank(G_rankID, g_rankname);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<G_rank> queryG_rank() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_rankDao G_rankDao = new G_rankDaoImpl(conn);
		List<G_rank> list = G_rankDao.queryG_rank();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

}
