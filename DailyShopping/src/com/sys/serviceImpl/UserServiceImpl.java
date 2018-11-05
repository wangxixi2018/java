package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.U_LimitDao;
import com.sys.dao.U_LoginDao;
import com.sys.dao.UserDao;
import com.sys.daoImpl.U_LimitDaoImpl;
import com.sys.daoImpl.U_LoginDaoImpl;
import com.sys.daoImpl.UserDaoImpl;
import com.sys.model.U_Limit;
import com.sys.model.U_Login;
import com.sys.model.User;
import com.sys.service.UserService;
import com.sys.util.JDBCUtil;


public class UserServiceImpl implements UserService{
	
	@Override
	public boolean addUser(User user) {
		Connection conn=null;
		int num1 = 0;
		int num2 = 0;
		boolean flag = false;
		try {
			conn = JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			if(user.getU_loginName()!=null){
				conn.setAutoCommit(false);
				num1 = userDao.registUser(user);
				int u_id=userDao.getU_IdByU_LoginName(user.getU_loginName());
				U_LoginDao u_loginDao = new U_LoginDaoImpl(conn);
				U_Login u_login = new U_Login();
				u_login.setU_ID(u_id);
				u_login.setU_LoginName(user.getU_loginName());
				u_login.setU_LoginPwd(user.getU_loginPwd());
				num2 = u_loginDao.addU_Login(u_login);
				if(num1==1 && num2==1){
					conn.commit();
					flag=true;
				}else{
					conn.rollback();
					flag=false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return flag;
	}

	@Override
	public boolean delUser(int u_id) {
		Connection conn=null;
		int num = 0;
		boolean flag = false;
		try {
			conn = JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			if(u_id!=0){
				conn.setAutoCommit(false);
				num = userDao.deleteUser(u_id);
				if(num!=0){
					conn.commit();
					flag=true;
				}else{
					conn.rollback();
					flag=false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return flag;
	}

	@Override
	public boolean updateUser(User user) {
		Connection conn=null;
		int num = 0;
		boolean flag = false;
		try {
			conn = JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			if(user.getU_id()!=0){
				conn.setAutoCommit(false);
				num = userDao.updateUser(user);
				if(num==1){
					conn.commit();
					flag=true;
				}else{
					conn.rollback();
					flag=false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return flag;
	}

	@Override
	public List<User> getUser() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			list = userDao.findUser();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public User getUserById(int u_id) {
		User user = null;
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			user = userDao.findUserByUserId(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return user;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		User user = null;
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			int u_id = userDao.getU_IdByU_LoginName(loginName);
			user = userDao.findUserByUserId(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return user;
	}

	@Override
	public int getU_IdByLoginName(String loginName) {
		int num =0;
		Connection conn = null;
		try {
			conn=JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			num= userDao.getU_IdByU_LoginName(loginName);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return num;
	}
//登陆
	@Override
	public Object[] doLoging(U_Login u_login) {
		Connection conn=null;
		Object[] obj=new Object[2];
		String str="";
		String flag="false";
		try {
			conn =JDBCUtil.getConnection();
			U_LoginDao u_logins = new U_LoginDaoImpl(conn);
			if(u_login!=null){
				List<U_Login> list = u_logins.findU_Login();
				for(U_Login u:list){
					if(u.getU_LoginName().equals(u_login.getU_LoginName())){
						if(u.getU_LoginPwd().equals(u_login.getU_LoginPwd())){
							str="登陆成功";
							flag="true";
							obj[0]=str;
							obj[1]=flag;
						}else{
							str="密码不正确";
							flag="false";
							obj[0]=str;
							obj[1]=flag;
						}
						return obj;
					}else{
						str="账号不存在";
						flag="false";
						obj[0]=str;
						obj[1]=flag;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return obj;
	}
//（注册用户名检查）
	@Override
	public boolean register_inspect(String username) {
		boolean flag = false;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			U_LoginDao u_logins = new U_LoginDaoImpl(conn);
			U_Login u_login = u_logins.getUserByName(username);
			if(u_login!=null && (u_login.getU_LoginName().equals(username))){
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public boolean updateU_lastlogin_time(int u_id) {
		Connection conn = null;
		int num = 0;
		try {
			conn =JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			UserDao userDao = new UserDaoImpl(conn);
			num = userDao.updateU_lastlogin_time(u_id);
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
	public String getU_lastlogin_time(int u_id) {
		Connection conn = null;
		String time = null;
		try {
			conn = JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			time = userDao.getU_lastlogin_time(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return time;
	}

	@Override
	public U_Limit getU_LimitByu_limit(int u_limit) {
		Connection conn = null;
		U_Limit u_limits = new U_Limit();
		try {
			conn = JDBCUtil.getConnection();
			U_LimitDao u_limitDao = new U_LimitDaoImpl(conn);
			u_limits = u_limitDao.getLimitByu_limit(u_limit);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return u_limits;
	}

	@Override
	public boolean updateU_picpath(String path, int u_id) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			conn.setAutoCommit(false);
			num = userDao.updateU_picPath(path,u_id);
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
	public String getU_picpathByU_id(int u_id) {
		Connection conn = null;
		String path = null;
		try {
			conn = JDBCUtil.getConnection();
			UserDao userDao = new UserDaoImpl(conn);
			path = userDao.getU_picPathByU_id(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return path;
	}

}
