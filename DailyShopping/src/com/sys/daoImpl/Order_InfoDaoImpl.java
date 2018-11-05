package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.Order_InfoDao;
import com.sys.model.Order_Info;
import com.sys.util.GetTime;
import com.sys.util.JDBCUtil;

public class Order_InfoDaoImpl extends BaseDao implements Order_InfoDao{

	public Order_InfoDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addO_Info(Order_Info order_info) {
		String sql = "INSERT INTO o_info(g_ID,o_price,o_totalprice,o_status,orderID,o_time,o_count) VALUES(?,?,?,?,?,NOW(),?);";
		int num = 0;
		num = super.executeUpdate(sql,order_info.getG_id(),order_info.getO_price(),order_info.getO_totalprice(),order_info.getO_status(),order_info.getOrderId(),order_info.getO_count());
		return num;
	}

	@Override
	public int delOrder_Info(int o_InfoId) {
		String sql = "DELETE FROM o_info  WHERE o_InfoID = ？;";
		int num = 0;
		num = super.executeUpdate(sql,o_InfoId);
		return num;
	}

	@Override
	public int updateOrder_Info(Order_Info order_info) {
		String sql = "UPDATE o_info SET g_ID=?,o_price=?,o_totalprice=?,o_status=?,orderID=?,o_time=NOW(),o_count=? WHERE o_InfoID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,order_info.getG_id(),order_info.getO_price(),order_info.getO_totalprice(),order_info.getO_status(),order_info.getOrderId(),order_info.getO_count(),order_info.getO_InfoId());
		return num;
	}

	@Override
	public List<Order_Info> findOrder_Info() {
		String sql = "SELECT * FROM o_info;";
		List<Order_Info> list = new ArrayList<Order_Info>();
		ResultSet rs = super.executeQuery(sql);
		try {
			while(rs.next()){
				Order_Info order_info = new Order_Info();
				order_info.setO_InfoId(rs.getInt("o_InfoID"));
				order_info.setG_id(rs.getInt("g_ID"));
				order_info.setO_price(rs.getDouble("o_price"));
				order_info.setO_totalprice(rs.getDouble("o_totalprice"));
				order_info.setO_status(rs.getInt("o_status"));
				order_info.setOrderId(rs.getInt("orderID"));
				order_info.setO_time(GetTime.getTime(rs,"o_time"));
				order_info.setO_count(rs.getInt("o_count"));
				order_info.setOrder_son_number(rs.getString("order_son_number"));
				list.add(order_info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public Order_Info findOrder_InfoById(int o_InfoId) {
		String sql = "SELECT * FROM o_info WHERE o_InfoID = ?;";
		ResultSet rs = super.executeQuery(sql,o_InfoId);
		Order_Info order_info = new Order_Info();
		try {
			while(rs.next()){
				order_info.setO_InfoId(rs.getInt("o_InfoID"));
				order_info.setG_id(rs.getInt("g_ID"));
				order_info.setO_price(rs.getDouble("o_price"));
				order_info.setO_totalprice(rs.getDouble("o_totalprice"));
				order_info.setO_status(rs.getInt("o_status"));
				order_info.setOrderId(rs.getInt("orderID"));
				order_info.setO_time(GetTime.getTime(rs,"o_time"));
				order_info.setO_count(rs.getInt("o_count"));
				order_info.setOrder_son_number(rs.getString("order_son_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return order_info;
	}

	@Override
	public List<Order_Info> findOrder_InfoByOrder_Id(int orderId) {
		String sql = "SELECT * FROM o_info WHERE orderID = ? ORDER BY o_time DESC;";
		List<Order_Info> list = new ArrayList<Order_Info>();
		ResultSet rs = super.executeQuery(sql,orderId);
		try {
			while(rs.next()){
				Order_Info order_info = new Order_Info();
				order_info.setO_InfoId(rs.getInt("o_InfoID"));
				order_info.setG_id(rs.getInt("g_ID"));
				order_info.setO_price(rs.getDouble("o_price"));
				order_info.setO_totalprice(rs.getDouble("o_totalprice"));
				order_info.setO_status(rs.getInt("o_status"));
				order_info.setOrderId(rs.getInt("orderID"));
				order_info.setO_time(GetTime.getTime(rs,"o_time"));
				order_info.setO_count(rs.getInt("o_count"));
				order_info.setOrder_son_number(rs.getString("order_son_number"));
				list.add(order_info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

}
