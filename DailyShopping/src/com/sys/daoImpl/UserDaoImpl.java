package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.UserDao;
import com.sys.model.User;
import com.sys.util.GetTime;
import com.sys.util.JDBCUtil;

public class UserDaoImpl extends BaseDao implements UserDao{

	public UserDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	//注销
	@Override
	public int deleteUser(int u_ID) {
		String sql="DELETE FROM u_login WHERE u_ID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,u_ID);
		return num;
	}
	
	//添加注册
	@Override
	public int registUser(User user) {
		String sql="INSERT INTO USER(u_email,u_Phone,u_registration_time,u_LoginName,u_lastlogin_time)VALUES (?,?,NOW(),?,NOW());";
		int num = 0;
		num = super.executeUpdate(sql,user.getU_email(),user.getU_phone(),user.getU_loginName());
		return num;
	}
	//修改信息
	@Override
	public int updateUser(User user) {
		int num = 0;
		if(user!=null){
			String sql="UPDATE USER SET u_Name=?,u_integral=?,u_RealName=?,u_Age=?,u_Sex=?,u_Phone=?,u_papers=?,u_address=?,u_email=? WHERE u_ID = ?; ";
			Object[] params =new Object[10];
			params[0]=user.getU_nc();
			params[1]=user.getU_integral();
			params[2]=user.getU_realName();
			params[3]=user.getU_age();
			params[4]=user.getU_sex();
			params[5]=user.getU_phone();
			params[6]=user.getU_papers();
			params[7]=user.getU_address();
			params[8]=user.getU_email();
			params[9]=user.getU_id();
			num = super.executeUpdate(sql,params);
		}
		return num;
	}

	@Override
	public User findUserByUserId(int u_id) {
		String sql="SELECT * FROM USER WHERE u_id = ?;";
		ResultSet rs = super.executeQuery(sql,u_id);
		User user= null;
		try {
			while(rs.next()){
				user = new User();
				user.setU_id(rs.getInt("u_ID"));
				user.setU_nc(rs.getString("u_Name"));
				user.setU_integral(rs.getInt("u_integral"));
				user.setU_realName(rs.getString("u_RealName"));
				user.setU_age(rs.getInt("u_Age"));
				user.setU_sex(rs.getString("u_Sex"));
				user.setU_phone(rs.getString("u_Phone"));
				user.setU_papers(rs.getString("u_papers"));
				user.setU_address(rs.getString("u_address"));
				user.setU_email(rs.getString("u_email"));
				user.setU_limit(rs.getInt("u_limit"));
				user.setU_loginName(rs.getString("u_LoginName"));
				user.setU_path(rs.getString("u_path"));
				user.setU_registration_time(GetTime.getTime(rs,"u_registration_time"));
				user.setU_lastlogin_time(GetTime.getTime(rs,"u_lastlogin_time"));
				user.setU_money(rs.getDouble("u_money"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return user;
	}

	@Override
	public List<User> findUser() {
		String sql="SELECT * FROM USER ;";
		ResultSet rs = super.executeQuery(sql);
		List<User> list = new ArrayList<User>();
		try {
			while(rs.next()){
				User user = new User();
				user.setU_id(rs.getInt("u_ID"));
				user.setU_nc(rs.getString("u_Name"));
				user.setU_integral(rs.getInt("u_integral"));
				user.setU_realName(rs.getString("u_RealName"));
				user.setU_age(rs.getInt("u_Age"));
				user.setU_sex(rs.getString("u_Sex"));
				user.setU_phone(rs.getString("u_Phone"));
				user.setU_papers(rs.getString("u_papers"));
				user.setU_address(rs.getString("u_address"));
				user.setU_email(rs.getString("u_email"));
				user.setU_limit(rs.getInt("u_limit"));
				user.setU_path(rs.getString("u_path"));
				user.setU_loginName(rs.getString("u_LoginName"));
				user.setU_registration_time(GetTime.getTime(rs,"u_registration_time"));
				user.setU_money(rs.getDouble("u_money"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}
	//通过登陆名查用户表id
	@Override
	public int getU_IdByU_LoginName(String u_loginName) {
		String sql ="SELECT u_ID FROM user WHERE SUBSTR(u_LoginName,1)=?;";
		int id=0;
		ResultSet rs = super.executeQuery(sql,u_loginName);
		try {
			while(rs.next()){
				id = rs.getInt("u_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return id;
	}

	@Override
	public int updateU_lastlogin_time(int u_id) {
		String sql="UPDATE USER SET u_lastlogin_time=NOW()  WHERE u_ID = ?;";
		int num  =0;
		num  =super.executeUpdate(sql,u_id);
		return num;
	}

	@Override
	public String getU_lastlogin_time(int u_id) {
		String sql="SELECT u_lastlogin_time FROM USER WHERE u_ID = ?;";
		ResultSet rs = super.executeQuery(sql,u_id);
		String time = null;
		try {
			while(rs.next()){
				time=GetTime.getTime(rs,"u_lastlogin_time");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public int updateU_picPath(String path,int u_id) {
		String sql="UPDATE USER SET u_path=? WHERE u_ID =?;";
		int num  =0;
		num = super.executeUpdate(sql,path,u_id);
		return num;
	}

	@Override
	public String getU_picPathByU_id(int u_id) {
		String path=null;
		String sql = "SELECT u_path FROM USER WHERE u_ID = ?;";
		ResultSet rs = super.executeQuery(sql,u_id);
		try {
			while(rs.next()){
				path=rs.getString("u_path");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return path;
	}
}
