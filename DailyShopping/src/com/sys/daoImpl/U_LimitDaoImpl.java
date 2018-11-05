package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.U_LimitDao;
import com.sys.model.U_Limit;
import com.sys.util.JDBCUtil;

public class U_LimitDaoImpl extends BaseDao implements U_LimitDao{

	public U_LimitDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addu_limit(U_Limit u_limit) {
		String sql="INSERT INTO u_limit(u_Limitname,u_Limitnumber)VALUES(?,?);";
		int num=0;
		num = super.executeUpdate(sql,u_limit.getU_LimitName(),u_limit.getU_LimitNumber());
		return num;
	}

	@Override
	public int deleteu_limit(int u_LimitID) {
		String sql="DELETE FROM u_limit WHERE u_LimitID = ?;";
		int num=0;
		num = super.executeUpdate(sql,u_LimitID);
		return num;
	}

	@Override
	public int updateu_limit(U_Limit u_limit) {
		int num = 0;
		if(u_limit!=null){
			String sql="update u_limit set u_Limitname=?,u_Limitnumber=? where u_LimitID=?;";
			num = super.executeUpdate(sql,u_limit.getU_LimitName(),u_limit.getU_LimitNumber(),u_limit.getU_LimitID());
		}
		return num;
	}

	@Override
	public List<U_Limit> findu_limit() {
		String sql = "SELECT * FROM u_limit;";
		ResultSet rs = super.executeQuery(sql);
		List<U_Limit> list = new ArrayList<U_Limit>();
		try {
			while(rs.next()){
				U_Limit  u_limit = new U_Limit();
				u_limit.setU_LimitID(rs.getInt("u_LimitID"));
				u_limit.setU_LimitName(rs.getString("u_Limitname"));
				u_limit.setU_LimitNumber(rs.getInt("u_Limitnumber"));
				list.add(u_limit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public U_Limit getLimitByu_limit(int u_limit) {
		String sql="SELECT * FROM u_limit WHERE u_LimitID=?;";
		U_Limit u_limits = new U_Limit();
		ResultSet rs= super.executeQuery(sql,u_limit);
		try {
			while(rs.next()){
				u_limits.setU_LimitID(rs.getInt("u_LimitID"));
				u_limits.setU_LimitName(rs.getString("u_Limitname"));
				u_limits.setU_LimitNumber(rs.getInt("u_Limitnumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return u_limits;
	}

}
