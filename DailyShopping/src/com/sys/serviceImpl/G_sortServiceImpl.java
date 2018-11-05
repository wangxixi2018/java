package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.G_sortDao;
import com.sys.daoImpl.G_sortDaoImpl;
import com.sys.model.G_sort;
import com.sys.service.G_sortService;
import com.sys.util.JDBCUtil;

public class G_sortServiceImpl implements G_sortService {

	@Override
	public int addG_sort(String G_sort) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sortDao G_sortDao = new G_sortDaoImpl(conn);
		int num = G_sortDao.addG_sort(G_sort);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delG_sort(String G_sort) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sortDao G_sortDao = new G_sortDaoImpl(conn);
		int num = G_sortDao.delG_sort(G_sort);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateG_sort(int G_sortID, String G_sort) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sortDao G_sortDao = new G_sortDaoImpl(conn);
		int num = G_sortDao.updateG_sort(G_sortID, G_sort);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<G_sort> queryG_sort() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_sortDao G_sortDao = new G_sortDaoImpl(conn);
		List<G_sort> list = G_sortDao.queryG_sort();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

}
