package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_sort2Dao;
import com.sys.model.G_sort2;
import com.sys.util.JDBCUtil;

public class G_sort2DaoImpl extends BaseDao implements G_sort2Dao {

	public G_sort2DaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_sort2(String G_sort2) {
		String sql = "INSERT INTO G_sort2 (g_sName) VALUES (?)";
		return super.executeUpdate(sql, G_sort2);
	}

	@Override
	public int delG_sort2(String g_sName) {
		String sql = "DELETE FROM  G_sort2 WHERE g_sName=?";
		return super.executeUpdate(sql, g_sName);
	}

	@Override
	public int updateG_sort2(int G_sort2ID, String g_sName) {
		String sql = "UPDATE G_sort2 set g_sName=? WHERE G_sort2ID=?";
		return super.executeUpdate(sql, g_sName, G_sort2ID);
	}

	@Override
	public List<G_sort2> queryG_sort2() {
		String sql = "SELECT G_sort2ID,g_sName FROM G_sort2";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_sort2> list = new ArrayList<G_sort2>();
		G_sort2 G_sort2 = null;
		try {
			while (resultSet.next()) {
				G_sort2 = new G_sort2();
				G_sort2.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				G_sort2.setG_sName(resultSet.getString("g_sName"));
				list.add(G_sort2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public G_sort2 getG_sort2ById(int g_sort2ID) {
		String sql = "SELECT G_sort2ID,g_sName FROM G_sort2 WHERE g_sort2ID = ?;";
		G_sort2 g_sort2 = new G_sort2();
		ResultSet rs = super.executeQuery(sql, g_sort2ID);
		try {
			while (rs.next()) {
				g_sort2.setG_sort2ID(rs.getInt("G_sort2ID"));
				g_sort2.setG_sName(rs.getString("g_sName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return g_sort2;
	}

}
