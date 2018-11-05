package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.Order_statusDao;
import com.sys.model.Order_status;
import com.sys.util.JDBCUtil;

public class Order_statusDaoImpl extends BaseDao implements Order_statusDao{

	public Order_statusDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addOrder_status(Order_status o_status) {
		String sql = "INSERT INTO o_status (o_statusname) VALUES(?);";
		int num = 0;
		num = super.executeUpdate(sql,o_status.getO_statusName());
		return num;
	}

	@Override
	public int delOrder_status(int o_statusId) {
		String sql = "DELETE FROM o_status WHERE o_statusID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,o_statusId);
		return num;
	}

	@Override
	public int updateOrder_status(Order_status o_status) {
		String sql = "UPDATE o_status SET o_statusname = ? WHERE o_statusID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,o_status.getO_statusName(),o_status.getO_statusId());
		return num;
	}

	@Override
	public List<Order_status> findOrder_status() {
		String sql = "SELECT * FROM o_status;";
		List<Order_status> list = new ArrayList<Order_status>();
		ResultSet rs = super.executeQuery(sql);
		try {
			while(rs.next()){
				Order_status o_status = new Order_status();
				o_status.setO_statusId(rs.getInt("o_statusID"));
				o_status.setO_statusName(rs.getString("o_statusname"));
				list.add(o_status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public Order_status findOrder_statusById(int o_statusId) {
		String sql = "SELECT * FROM o_status WHERE o_statusID = ?;";
		Order_status o_status = new Order_status();
		ResultSet rs = super.executeQuery(sql,o_statusId);
		try {
			while(rs.next()){
				o_status.setO_statusId(rs.getInt("o_statusID"));
				o_status.setO_statusName(rs.getString("o_statusname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return o_status;
	}

}
