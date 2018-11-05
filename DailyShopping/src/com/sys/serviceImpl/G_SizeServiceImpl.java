package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.G_SizeDao;
import com.sys.daoImpl.G_SizeDaoImpl;
import com.sys.model.G_Size;
import com.sys.service.G_SizeService;
import com.sys.util.JDBCUtil;

/**
 * 商品规格Service 业务层接口实现
 * 
 * @author Administrator
 *
 */
public class G_SizeServiceImpl implements G_SizeService {

	@Override
	public int addG_Size(String g_Size) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_SizeDao g_SizeDao = new G_SizeDaoImpl(conn);
		int num = g_SizeDao.addG_Size(g_Size);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delG_Size(String g_Size) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_SizeDao g_SizeDao = new G_SizeDaoImpl(conn);
		int num = g_SizeDao.delG_Size(g_Size);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateG_Size(int g_SizeID, String g_Size) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_SizeDao g_SizeDao = new G_SizeDaoImpl(conn);
		int num = g_SizeDao.updateG_Size(g_SizeID, g_Size);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<G_Size> queryG_Size() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		G_SizeDao g_SizeDao = new G_SizeDaoImpl(conn);
		List<G_Size> list = g_SizeDao.queryG_Size();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public G_Size getG_SizeById(int g_sizeID) {
		Connection conn = null;
		G_Size g_size = new G_Size();
		try {
			conn = JDBCUtil.getConnection();
			G_SizeDao g_SizeDao = new G_SizeDaoImpl(conn);
			g_size = g_SizeDao.getG_SizeByid(g_sizeID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return g_size;
	}

}
