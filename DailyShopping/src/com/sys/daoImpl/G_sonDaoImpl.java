package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_sonDao;
import com.sys.model.G_son;

public class G_sonDaoImpl extends BaseDao implements G_sonDao {

	public G_sonDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_son(String G_son, String g_describe) {
		String sql = "INSERT INTO g_son (g_sName,g_describe) VALUES (?,?)";
		return super.executeUpdate(sql, G_son, g_describe);
	}

	@Override
	public int delG_son(int g_sonID) {
		String sql = "DELETE FROM  g_son WHERE g_sonID=?";
		return super.executeUpdate(sql, g_sonID);
	}

	@Override
	public int updateG_son(int G_sonID, G_son G_son) {

		StringBuffer sql = new StringBuffer("UPDATE g_son set ");
		if (G_son != null) {
			if (G_son.getG_sName() != null) {
				sql.append("g_sName=" + G_son.getG_sName() + ",");
			}
			if (G_son.getG_describe() != null) {
				sql.append("g_describe=" + G_son.getG_describe() + ",");
			}
			sql.replace(sql.length() - 1, sql.length(), " ");
			sql.append("WHERE G_sonID=?");
		}
		return super.executeUpdate(sql.toString(), G_sonID);
	}

	@Override
	public List<G_son> queryG_son() {
		String sql = "SELECT g_sonID,g_sName,g_describe FROM g_son";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_son> list = new ArrayList<G_son>();
		G_son G_son = null;
		try {
			while (resultSet.next()) {
				G_son = new G_son();
				G_son.setG_sonID(resultSet.getInt("g_sonID"));
				G_son.setG_sName(resultSet.getString("g_sName"));
				G_son.setG_describe(resultSet.getString("g_describe"));
				list.add(G_son);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<G_son> queryG_son(int G_sonID) {
		String sql = "SELECT g_sonID,g_sName,g_describe FROM g_son where g_sonID=? ";
		ResultSet resultSet = super.executeQuery(sql, G_sonID);
		List<G_son> list = new ArrayList<G_son>();
		G_son G_son = null;
		try {
			while (resultSet.next()) {
				G_son = new G_son();
				G_son.setG_sonID(resultSet.getInt("g_sonID"));
				G_son.setG_sName(resultSet.getString("g_sName"));
				G_son.setG_describe(resultSet.getString("g_describe"));
				list.add(G_son);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
