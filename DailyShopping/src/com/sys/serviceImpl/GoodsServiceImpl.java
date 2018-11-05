package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.GoodsDao;
import com.sys.daoImpl.GoodsDaoImpl;
import com.sys.model.Goods;
import com.sys.service.GoodsService;
import com.sys.util.JDBCUtil;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public int addGoods(Goods Goods) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		int num = GoodsDao.addGoods(Goods);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int delGoods(int g_ID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		int num = GoodsDao.delGoods(g_ID);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public int updateGoods(int g_ID, Goods Goods) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		int num = GoodsDao.updateGoods(g_ID, Goods);
		JDBCUtil.closeAll(conn, null, null);
		return num;
	}

	@Override
	public List<Goods> queryGoods() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoods();
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoods(int g_ID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoods(g_ID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_sonID(int g_sonID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_sonID(g_sonID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_sort1ID(int g_sort1ID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_sort1ID(g_sort1ID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceDown(int g_sort2ID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_g_priceDown(g_sort2ID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_sort2ID(int g_sort2ID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_sort2ID(g_sort2ID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceUp(int g_sort2ID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_g_priceUp(g_sort2ID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsColors(Goods goods) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsColors(goods);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsSrc(Goods goods) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsSrc(goods);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsort(Goods goods) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsort(goods);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceSonDown(int g_sonID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_g_priceSonDown(g_sonID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

	@Override
	public List<Goods> queryGoodsg_g_priceSonUp(int g_sonID) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoodsDao GoodsDao = new GoodsDaoImpl(conn);
		List<Goods> list = GoodsDao.queryGoodsg_g_priceSonUp(g_sonID);
		JDBCUtil.closeAll(conn, null, null);
		return list;
	}

}
