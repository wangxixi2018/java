package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_rankDao;
import com.sys.model.G_rank;

public class G_rankDaoImpl extends BaseDao implements G_rankDao {

	public G_rankDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_rank(String g_rank) {
		String sql = "INSERT INTO g_rank (g_rankname) VALUES (?)";
		return super.executeUpdate(sql, g_rank);
	}

	@Override
	public int delG_rank(String g_rankname) {
		String sql = "DELETE FROM  g_rank WHERE g_rankname=?";
		return super.executeUpdate(sql, g_rankname);
	}

	@Override
	public int updateG_rank(int G_rankID, String g_rankname) {
		String sql = "UPDATE g_rank set g_rankname=? WHERE G_rankID=?";
		return super.executeUpdate(sql, g_rankname, G_rankID);
	}

	@Override
	public List<G_rank> queryG_rank() {
		String sql = "SELECT g_rankID,g_rankname FROM g_rank";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_rank> list = new ArrayList<G_rank>();
		G_rank G_rank = null;
		try {
			while (resultSet.next()) {
				try {
					G_rank = new G_rank();
					G_rank.setG_rankID(resultSet.getInt("g_rankID"));
					G_rank.setG_rankname(resultSet.getString("g_rankname"));
					list.add(G_rank);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
