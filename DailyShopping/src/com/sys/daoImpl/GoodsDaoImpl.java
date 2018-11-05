package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.GoodsDao;
import com.sys.model.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {

	public GoodsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addGoods(Goods Goods) {
		String sql = "INSERT INTO goods (G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID) VALUES (?,?,?,?,?,?,?,?,?)";
		return super.executeUpdate(sql, Goods.getG_sort1ID(), Goods.getG_sort2ID(), Goods.getG_sonID(),
				Goods.getG_colorsID(), Goods.getG_sizeID(), Goods.getG_integral(), Goods.getG_g_price(),
				Goods.getG_src(), Goods.getG_rankID());
	}

	@Override
	public int delGoods(int g_ID) {
		String sql = "DELETE FROM  goods WHERE g_ID=?";
		return super.executeUpdate(sql, g_ID);
	}

	@Override
	public int updateGoods(int g_ID, Goods Goods) {
		StringBuffer sql = new StringBuffer("UPDATE goods set ");
		if (Goods != null) {
			if (Goods.getG_sort1ID() != 0) {
				sql.append("G_sort1ID=" + Goods.getG_sort1ID() + ",");
			}
			if (Goods.getG_sort2ID() != 0) {
				sql.append("G_sort2ID=" + Goods.getG_sort2ID() + ",");
			}
			if (Goods.getG_sonID() != 0) {
				sql.append("g_sonID=" + Goods.getG_sonID() + ",");
			}
			if (Goods.getG_colorsID() != 0) {
				sql.append("g_colorsID=" + Goods.getG_colorsID() + ",");
			}
			if (Goods.getG_sizeID() != 0) {
				sql.append("g_sizeID=" + Goods.getG_sizeID() + ",");
			}
			if (Goods.getG_integral() != 0) {
				sql.append("g_integral='" + Goods.getG_integral() + "',");
			}
			if (Goods.getG_g_price() != 0) {
				sql.append("g_g_price='" + Goods.getG_g_price() + "',");
			}
			if (Goods.getG_src() != null) {
				sql.append("g_src='" + Goods.getG_src() + "',");
			}
			if (Goods.getG_rankID() != 0) {
				sql.append("g_rankID='" + Goods.getG_rankID() + "',");
			}
		}
		sql.replace(sql.length() - 1, sql.length(), " ");
		sql.append("WHERE g_ID=?");
		return super.executeUpdate(sql.toString(), g_ID);
	}

	@Override
	public List<Goods> queryGoods() {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods";
		ResultSet resultSet = super.executeQuery(sql);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_colorsID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoods(int g_ID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods where g_ID=?";
		ResultSet resultSet = super.executeQuery(sql, g_ID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_sonID(int g_sonID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods where g_sonID=?";
		ResultSet resultSet = super.executeQuery(sql, g_sonID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_sort1ID(int g_sort1ID) {
		String sql = "SELECT g_sort1ID, g_sonID FROM goods WHERE g_sort1ID=? GROUP BY g_sonID";
		ResultSet resultSet = super.executeQuery(sql, g_sort1ID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceDown(int g_sort2ID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sort2ID=? ORDER BY g_g_price DESC";
		ResultSet resultSet = super.executeQuery(sql, g_sort2ID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_sort2ID(int g_sort2ID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sort2ID=? ";
		ResultSet resultSet = super.executeQuery(sql, g_sort2ID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceUp(int g_sort2ID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sort2ID=? ORDER BY g_g_price ";
		ResultSet resultSet = super.executeQuery(sql, g_sort2ID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsColors(Goods goods) {
		// System.out.println(goods.getG_sort1ID() + "|" + goods.getG_sort2ID() + "|" +
		// goods.getG_sonID() + "|"+ goods.getG_colorsID());
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sort1ID=? AND g_sort2ID=? AND  g_sonID=? AND g_colorsID=? ";
		ResultSet resultSet = super.executeQuery(sql, goods.getG_sort1ID(), goods.getG_sort2ID(), goods.getG_sonID(),
				goods.getG_colorsID());
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsSrc(Goods goods) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sort1ID=? AND g_sort2ID=? AND  g_sonID=? AND g_id NOT IN (?)";
		ResultSet resultSet = super.executeQuery(sql, goods.getG_sort1ID(), goods.getG_sort2ID(), goods.getG_sonID(),
				goods.getG_ID());
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsort(Goods goods) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sort1ID=? AND g_sort2ID=? AND  g_sonID=? GROUP BY g_colorsID ";
		ResultSet resultSet = super.executeQuery(sql, goods.getG_sort1ID(), goods.getG_sort2ID(), goods.getG_sonID());
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceSonDown(int g_sonID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sonID=? ORDER BY g_g_price DESC";
		ResultSet resultSet = super.executeQuery(sql, g_sonID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceSonUp(int g_sonID) {
		String sql = "SELECT g_ID,G_sort1ID,G_sort2ID,g_sonID,g_colorsID,g_sizeID,g_integral,g_g_price,g_src,g_rankID FROM goods WHERE g_sonID=? ORDER BY g_g_price ";
		ResultSet resultSet = super.executeQuery(sql, g_sonID);
		List<Goods> list = new ArrayList<Goods>();
		Goods Goods = null;
		try {
			while (resultSet.next()) {
				Goods = new Goods();
				Goods.setG_ID(resultSet.getInt("g_ID"));
				Goods.setG_sort1ID(resultSet.getInt("G_sort1ID"));
				Goods.setG_sort2ID(resultSet.getInt("G_sort2ID"));
				Goods.setG_sonID(resultSet.getInt("g_sonID"));
				Goods.setG_colorsID(resultSet.getInt("g_colorsID"));
				Goods.setG_sizeID(resultSet.getInt("g_sizeID"));
				Goods.setG_integral(resultSet.getInt("g_integral"));
				Goods.setG_g_price(resultSet.getInt("g_g_price"));
				Goods.setG_src(resultSet.getString("g_src"));
				Goods.setG_rankID(resultSet.getInt("g_rankID"));
				list.add(Goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
