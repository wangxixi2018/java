package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.OrdertakeSiteDao;
import com.sys.model.OrdertakeSite;

public class OrdertakeSiteDaoImpl extends BaseDao implements OrdertakeSiteDao{

	public OrdertakeSiteDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addOrdertakeSite(OrdertakeSite ordertakesite) throws SQLException {
		int num=0;
		String sql="insert into ordertakeSite(o_takeSiteID,o_name,o_phone,o_add)"
				+ "values(?,?,?,?)";
		Object[] params=new Object[4];
		params[0]=ordertakesite.getO_takeSiteID();
		params[1]=ordertakesite.getO_name();
		params[2]=ordertakesite.getO_phone();
		params[3]=ordertakesite.getO_add();
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public int delOrdertakeSite(int o_takeSiteID) throws SQLException {
		int num=0;
		String sql="delete from ordertakeSite where o_takeSiteID=?";
		Object[] params=new Object[1];
		params[0]=o_takeSiteID;
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public int updateOrdertakeSite(OrdertakeSite ordertakesite) throws SQLException {
		int num=0;
		String sql="update ordertakeSite set o_name=?,o_phone=?,o_add=? where o_takeSiteID=? ";
		Object[] params=new Object[4];
		params[0]=ordertakesite.getO_name();
		params[1]=ordertakesite.getO_phone();
		params[2]=ordertakesite.getO_add();
		params[3]=ordertakesite.getO_takeSiteID();
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public List<OrdertakeSite> getAllOrdertakeSite() throws SQLException {
		List<OrdertakeSite> list=new ArrayList<OrdertakeSite>();
		OrdertakeSite ordertakesite=null;
		String sql="select o_takeSiteID,o_name,o_phone,o_add from ordertakeSite";
		ResultSet rs=super.executeQuery(sql);
		while(rs.next()) {
			ordertakesite=new OrdertakeSite();
			ordertakesite.setO_takeSiteID(rs.getInt("o_takeSiteID"));
			ordertakesite.setO_name(rs.getString("o_name"));
			ordertakesite.setO_phone(rs.getString("o_phone"));
			ordertakesite.setO_add(rs.getString("o_add"));
			list.add(ordertakesite);
		}
		return list;
	}

}
