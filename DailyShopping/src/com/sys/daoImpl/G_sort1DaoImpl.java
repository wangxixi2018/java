package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_sort1Dao;
import com.sys.model.G_sort1;
import com.sys.util.JDBCUtil;

public class G_sort1DaoImpl extends BaseDao implements G_sort1Dao {

	public G_sort1DaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_sort1(String G_sort1) {
		String sql = "INSERT INTO G_sort1 (g_sName) VALUES (?)";
		return super.executeUpdate(sql, G_sort1);
	}

	@Override
	public int delG_sort1(String g_sName) {
		String sql = "DELETE FROM  G_sort1 WHERE g_sName=?";
		return super.executeUpdate(sql, g_sName);
	}

	@Override
	public int updateG_sort1(int G_sort1ID, String g_sName) {
		String sql = "UPDATE G_sort1 set g_sName=? WHERE G_sort1ID=?";
		return super.executeUpdate(sql, g_sName, G_sort1ID);
	}

	@Override
	public List<G_sort1> queryG_sort1() {
		String sql = "SELECT G_sort1ID,g_sName FROM G_sort1";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_sort1> list = new ArrayList<G_sort1>();
		G_sort1 G_sort1 = null;
		try {
			while (resultSet.next()) {
				G_sort1 = new G_sort1();
				G_sort1.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				G_sort1.setG_sName(resultSet.getString("g_sName"));
				list.add(G_sort1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public G_sort1 getG_sort1ById(int g_sort1ID) {
		String sql = "SELECT G_sort1ID,g_sName FROM G_sort1 WHERE G_sort1ID = ?;";
		G_sort1 g_sort1 = new G_sort1();
		ResultSet rs = super.executeQuery(sql, g_sort1ID);
		try {
			while (rs.next()) {
				g_sort1.setG_sort1ID(rs.getInt("G_sort1ID"));
				g_sort1.setG_sName(rs.getString("g_sName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return g_sort1;
	}

}
