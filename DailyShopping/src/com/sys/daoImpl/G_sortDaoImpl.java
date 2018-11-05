package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_sortDao;
import com.sys.model.G_sort;

public class G_sortDaoImpl extends BaseDao implements G_sortDao {

	public G_sortDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_sort(String G_sort) {
		String sql = "INSERT INTO g_sort (g_sName) VALUES (?)";
		return super.executeUpdate(sql, G_sort);
	}

	@Override
	public int delG_sort(String g_sName) {
		String sql = "DELETE FROM  g_sort WHERE g_sName=?";
		return super.executeUpdate(sql, g_sName);
	}

	@Override
	public int updateG_sort(int G_sortID, String g_sName) {
		String sql = "UPDATE g_sort set g_sName=? WHERE g_sortID=?";
		return super.executeUpdate(sql, g_sName, G_sortID);
	}

	@Override
	public List<G_sort> queryG_sort() {
		String sql = "SELECT g_sortID,g_sName FROM g_sort";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_sort> list = new ArrayList<G_sort>();
		G_sort G_sort = null;
		try {
			while (resultSet.next()) {
				G_sort = new G_sort();
				G_sort.setG_sortID(resultSet.getInt("g_sortID"));
				G_sort.setG_sName(resultSet.getString("g_sName"));
				list.add(G_sort);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
