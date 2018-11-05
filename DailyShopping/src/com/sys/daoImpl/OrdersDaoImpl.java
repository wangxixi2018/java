package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.OrdersDao;
import com.sys.model.Orders;
import com.sys.util.GetTime;
import com.sys.util.JDBCUtil;

public class OrdersDaoImpl extends BaseDao implements OrdersDao{

	public OrdersDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addOrders(Orders orders) {
		String sql = "INSERT INTO orders(o_statusID,u_ID,o_money,o_add,o_name,o_phone,order_Time,order_number,payment) VALUES(?,?,?,?,?,?,NOW(),?,?);";
		int num = 0;
		num = super.executeUpdate(sql,orders.getO_statusId(),orders.getU_id(),orders.getO_money(),orders.getO_add(),orders.getO_name(),orders.getO_phone(),orders.getOrder_number(),orders.getPayment());
		return num;
	}

	@Override
	public int delOrders(int orderId) {
		String sql = "DELETE FROM orders WHERE orderID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,orderId);
		return num;
	}

	@Override
	public int updateOrders(Orders orders) {
		String sql = "UPDATE orders SET o_statusID=?,o_money=?,o_add=?,o_name=?,o_phone=?,payment=? WHERE orderID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,orders.getO_statusId(),orders.getO_money(),orders.getO_add(),orders.getO_name(),orders.getO_phone(),orders.getPayment(),orders.getOrderId());
		return num;
	}

	@Override
	public List<Orders> findOrders() {
		String sql = "SELECT * FROM orders;";
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = super.executeQuery(sql);
		try {
			while(rs.next()){
				Orders orders = new Orders();
				orders.setOrderId(rs.getInt("orderID"));
				orders.setO_statusId(rs.getInt("o_statusID"));
				orders.setU_id(rs.getInt("u_ID"));
				orders.setO_money(rs.getDouble("o_money"));
				orders.setO_add(rs.getString("o_add"));
				orders.setO_name(rs.getString("o_name"));
				orders.setO_phone(rs.getString("o_phone"));
				orders.setOrder_Time(GetTime.getTime(rs,"order_Time"));
				orders.setOrder_number(rs.getString("order_number"));
				orders.setPayment(rs.getString("payment"));
				list.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public Orders findOrdersById(int orderId) {
		String sql = "SELECT * FROM orders WHERE orderID = ?;";
		Orders orders = new Orders();
		ResultSet rs = super.executeQuery(sql,orderId);
		try {
			while(rs.next()){
				orders.setOrderId(rs.getInt("orderID"));
				orders.setO_statusId(rs.getInt("o_statusID"));
				orders.setU_id(rs.getInt("u_ID"));
				orders.setO_money(rs.getDouble("o_money"));
				orders.setO_add(rs.getString("o_add"));
				orders.setO_name(rs.getString("o_name"));
				orders.setO_phone(rs.getString("o_phone"));
				orders.setOrder_Time(GetTime.getTime(rs,"order_Time"));
				orders.setOrder_number(rs.getString("order_number"));
				orders.setPayment(rs.getString("payment"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return orders;
	}

	@Override
	public List<Orders> findOrdersByU_Id(int u_id) {
		String sql = "SELECT * FROM orders WHERE u_id = ? ORDER BY order_Time DESC;";
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = super.executeQuery(sql,u_id);
		try {
			while(rs.next()){
				Orders orders = new Orders();
				orders.setOrderId(rs.getInt("orderID"));
				orders.setO_statusId(rs.getInt("o_statusID"));
				orders.setU_id(rs.getInt("u_ID"));
				orders.setO_money(rs.getDouble("o_money"));
				orders.setO_add(rs.getString("o_add"));
				orders.setO_name(rs.getString("o_name"));
				orders.setO_phone(rs.getString("o_phone"));
				orders.setOrder_Time(GetTime.getTime(rs,"order_Time"));
				orders.setOrder_number(rs.getString("order_number"));
				orders.setPayment(rs.getString("payment"));
				list.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public int findOrderIdByOrder_number(String order_number) {
		String sql = "SELECT orderID FROM orders WHERE order_number = ?;";
		int num = 0;
		ResultSet rs = super.executeQuery(sql,order_number);
		try {
			while(rs.next()){
				num = rs.getInt("orderID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return num;
	}

}
