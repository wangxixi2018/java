package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.O_InfoDao;
import com.sys.model.O_Info;

public class O_InfoDaoImpl extends BaseDao implements O_InfoDao{

	public O_InfoDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<O_Info> getAllO_Info() throws SQLException {
		List<O_Info> list=new ArrayList<O_Info>();
		O_Info oinfo=null;
		String sql="select o_InfoID,g_ID,o_number,o_time,o_price,"
				+ "o_name,o_color,o_Size,o_totalprice,o_status from o_Info";
		ResultSet rs=super.executeQuery(sql);
		while(rs.next()) {
			oinfo=new O_Info();
			oinfo.setO_InfoID(rs.getInt("o_InfoID"));
			oinfo.setG_ID(rs.getInt("g_ID"));
			oinfo.setO_number(rs.getInt("o_number"));
			oinfo.setO_time(rs.getString("o_time"));
			oinfo.setO_price(rs.getDouble("o_price"));
			oinfo.setO_name(rs.getString("o_name"));
			oinfo.setO_color(rs.getInt("o_color"));
			oinfo.setO_Size(rs.getInt("o_Size"));
			oinfo.setO_totalprice(rs.getDouble("o_totalprice"));
			oinfo.setO_status(rs.getInt("o_status"));
			list.add(oinfo);
		}
		return list;
	}
	
}
