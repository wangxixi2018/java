package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.U_LoginDao;
import com.sys.daoImpl.U_LoginDaoImpl;
import com.sys.model.U_Login;
import com.sys.model.User;
import com.sys.service.U_LoginService;
import com.sys.util.JDBCUtil;

public class U_LoginServiceImpl implements U_LoginService{

	@Override
	public boolean addU_login(User user) {
		Connection conn = null;
		int num = 0;
		try {
			conn =JDBCUtil.getConnection();
			U_LoginDao u_loginDao = new U_LoginDaoImpl(conn);
			conn.setAutoCommit(false);
			U_Login u_login = new U_Login();
			u_login.setU_ID(user.getU_id());
			u_login.setU_LoginName(user.getU_loginName());
			u_login.setU_LoginPwd(user.getU_loginPwd());
			num = u_loginDao.addU_Login(u_login);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public boolean delU_login(int u_id) {
		Connection conn = null;
		int num = 0;
		try {
			conn =JDBCUtil.getConnection();
			U_LoginDao u_loginDao = new U_LoginDaoImpl(conn);
			conn.setAutoCommit(false);
			num = u_loginDao.deleteU_Login(u_id);
			if(num!=0){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}
	//修改密碼
	@Override
	public boolean updateU_login(U_Login u_login) {
		Connection conn = null;
		int num = 0;
		try {
			conn =JDBCUtil.getConnection();
			U_LoginDao u_loginDao = new U_LoginDaoImpl(conn);
			conn.setAutoCommit(false);
			num = u_loginDao.updateU_Login(u_login);//修改密碼
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public List<U_Login> findAllU_Login() {
		Connection conn = null;
		List<U_Login> list =new ArrayList<U_Login>();
		try {
			conn =JDBCUtil.getConnection();
			U_LoginDao u_loginDao = new U_LoginDaoImpl(conn);
			list = u_loginDao.findU_Login();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<U_Login> findU_LoginByU_Id(int u_id) {
		Connection conn = null;
		List<U_Login> list =new ArrayList<U_Login>();
		try {
			conn =JDBCUtil.getConnection();
			U_LoginDao u_loginDao = new U_LoginDaoImpl(conn);
			list = u_loginDao.findU_LoginByu_id(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

}
