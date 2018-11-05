package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.User_loginDao;
import com.sys.model.User;

public class User_loginDaoImpl extends BaseDao implements User_loginDao{

	public User_loginDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getUser_login() {
		String sql="SELECT * FROM u_login;";
		ResultSet rs = super.executeQuery(sql);
		List<User> list = new ArrayList<User>();
		try {
			while(rs.next()){
				User user=new User();
				user.setU_loginName(rs.getString("u_loginName"));
				user.setU_loginPwd(rs.getString("u_loginpwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
