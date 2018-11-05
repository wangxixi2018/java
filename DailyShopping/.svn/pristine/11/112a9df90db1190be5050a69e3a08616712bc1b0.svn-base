package com.sys.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.User_loginDao;
import com.sys.daoImpl.User_loginDaoImpl;
import com.sys.model.User;
import com.sys.util.JDBCUtil;

public class DaoTest {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn = JDBCUtil.getConnection();
			User_loginDao user_loginDao = new User_loginDaoImpl(conn);
			List<User> list = user_loginDao.getUser_login();
			for(User u:list){
				System.out.println(u.getU_loginName()+"|"+u.getU_loginPwd());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		
	}
}
