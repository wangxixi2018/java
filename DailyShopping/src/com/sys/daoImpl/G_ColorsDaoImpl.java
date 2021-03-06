package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.G_ColorsDao;
import com.sys.model.G_Colors;

/**
 * 商品颜色刀层实现
 * 
 * @author Administrator
 *
 */
public class G_ColorsDaoImpl extends BaseDao implements G_ColorsDao {

	public G_ColorsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addG_Colors(String colsrs) {
		String sql = "INSERT INTO g_Colors (g_colors) VALUES (?)";
		return super.executeUpdate(sql, colsrs);
	}

	@Override
	public List<G_Colors> queryG_Colors() {
		String sql = "SELECT g_colorsID,g_colors FROM g_Colors";
		ResultSet resultSet = super.executeQuery(sql);
		List<G_Colors> list = new ArrayList<G_Colors>();
		G_Colors g_Colors = null;
		try {
			while (resultSet.next()) {
				try {
					g_Colors = new G_Colors();
					g_Colors.setG_colorsID(resultSet.getInt("g_colorsID"));
					g_Colors.setG_colors(resultSet.getString("g_colors"));
					list.add(g_Colors);
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

	@Override
	public int delG_Colors(String colsrs) {
		String sql = "DELETE FROM  g_Colors WHERE g_colors=?";
		return super.executeUpdate(sql, colsrs);
	}

	@Override
	public int updateG_Colors(int g_colorsID, String colsrs) {
		String sql = "UPDATE g_Colors set g_colors=? WHERE g_colorsID=?";
		return super.executeUpdate(sql, colsrs, g_colorsID);
	}

	@Override
	public List<G_Colors> queryG_Colors(int g_colorsID) {
		String sql = "SELECT g_colorsID,g_colors FROM g_colors WHERE g_colorsID=? ";
		ResultSet resultSet = super.executeQuery(sql, g_colorsID);
		List<G_Colors> list = new ArrayList<G_Colors>();
		G_Colors g_Colors = null;
		try {
			while (resultSet.next()) {
				try {
					g_Colors = new G_Colors();
					g_Colors.setG_colorsID(resultSet.getInt("g_colorsID"));
					g_Colors.setG_colors(resultSet.getString("g_colors"));
					list.add(g_Colors);
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
