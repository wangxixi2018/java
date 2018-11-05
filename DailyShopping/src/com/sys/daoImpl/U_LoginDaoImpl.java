package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.U_LoginDao;
import com.sys.model.U_Login;
import com.sys.util.JDBCUtil;

public class U_LoginDaoImpl extends BaseDao implements U_LoginDao{

	public U_LoginDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addU_Login(U_Login u_login) {
		String sql="INSERT INTO u_login(u_loginName,u_loginpwd,u_ID)VALUES(?,?,?);";
		int num = 0;
		num = super.executeUpdate(sql,u_login.getU_LoginName(),u_login.getU_LoginPwd(),u_login.getU_ID());
		return num;
	}

	@Override
	public int deleteU_Login(int u_ID) {
		String sql="DELETE FROM u_login WHERE u_LoginID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,u_ID);
		return num;
	}

	@Override
	public int updateU_Login(U_Login u_login) {
		String sql="UPDATE u_login SET u_loginpwd=? WHERE u_LoginID = ?;";
		int num=0;
		num = super.executeUpdate(sql,u_login.getU_LoginPwd(),u_login.getU_LoginID());
		return num;
	}

	@Override
	public List<U_Login> findU_Login() {
		String sql = "SELECT * FROM u_login;";
		List<U_Login> list = new ArrayList<U_Login>();
		ResultSet rs =super.executeQuery(sql);
		try {
			while(rs.next()){
				U_Login u_login = new U_Login();
				u_login.setU_ID(rs.getInt("u_ID"));
				u_login.setU_LoginID(rs.getInt("u_LoginID"));
				u_login.setU_LoginName(rs.getString("u_loginName"));
				u_login.setU_LoginPwd(rs.getString("u_loginpwd"));
				list.add(u_login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public U_Login getUserByName(String u_loginName) {
		String sql="SELECT * FROM u_login WHERE SUBSTR(u_LoginName,1)=?;";
		ResultSet rs = super.executeQuery(sql,u_loginName);
		U_Login u_login = null;
		try {
				while(rs.next()){
					u_login = new U_Login();
					u_login.setU_ID(rs.getInt("u_ID"));
					u_login.setU_LoginID(rs.getInt("u_LoginID"));
					u_login.setU_LoginName(rs.getString("u_loginName"));
					u_login.setU_LoginPwd(rs.getString("u_loginpwd"));
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return u_login;
	}

	@Override
	public List<U_Login> findU_LoginByu_id(int u_id) {
		String sql = "SELECT * FROM u_login where u_ID = ?;";
		List<U_Login> list = new ArrayList<U_Login>();
		ResultSet rs =super.executeQuery(sql,u_id);
		try {
			while(rs.next()){
				U_Login u_login = new U_Login();
				u_login.setU_ID(rs.getInt("u_ID"));
				u_login.setU_LoginID(rs.getInt("u_LoginID"));
				u_login.setU_LoginName(rs.getString("u_loginName"));
				u_login.setU_LoginPwd(rs.getString("u_loginpwd"));
				list.add(u_login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

}
