package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.UserDao;
import com.sys.model.User;
import com.sys.util.JDBCUtil;

public class UserDaoImpl extends BaseDao implements UserDao{

	public UserDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getLogin() {
		String sql="SELECT * FROM u_login;";
		ResultSet rs = super.executeQuery(sql);
		List<User> list = new ArrayList<User>();
		try {
			while(rs.next()){
				User user = new User();
				user.setU_loginName(rs.getString("u_loginName"));
				user.setU_loginPwd(rs.getString("u_loginpwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

}
