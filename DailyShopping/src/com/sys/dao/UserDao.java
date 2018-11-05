package com.sys.dao;

import java.util.List;

import com.sys.model.User;

public interface UserDao {
	public int registUser(User user);//注册
	public int deleteUser(int u_ID);//删除
	public int updateUser(User user);//修改
	public User findUserByUserId(int u_id);//查询
	public List<User> findUser();
	public int getU_IdByU_LoginName(String u_loginName);//通过登陆名查用户表id
	public int updateU_lastlogin_time(int u_id);//修改用户最近一次登陆的时间
	public String getU_lastlogin_time(int u_id);//查询用户最近一次登陆时间
	public int updateU_picPath(String path,int u_id);//修改用户的头像路径
	public String getU_picPathByU_id(int u_id);//获取用户头像路劲
}
