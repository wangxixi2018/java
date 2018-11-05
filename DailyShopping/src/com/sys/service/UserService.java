package com.sys.service;

import java.util.List;

import com.sys.model.U_Limit;
import com.sys.model.U_Login;
import com.sys.model.User;

public interface UserService {
	public Object[] doLoging(U_Login u_login);//登陆
	public boolean addUser(User user);//增加用户信息
	public boolean delUser(int u_id);//通过id删除（注销）用户
	public boolean updateUser(User user);//修改用户信息
	public List<User> getUser();//查询所有用户信息
	public User getUserById(int u_id);//通过id查询用户信息
	public User getUserByLoginName(String loginName);//通过登陆名字段查询用户信息
	public int getU_IdByLoginName(String loginName);//通过登陆名字段查询用户id
	public boolean register_inspect(String username);//注册检查
	public boolean updateU_lastlogin_time(int u_id);//修改最近一次登陆的时间
	public String getU_lastlogin_time(int u_id);//查询最近一次登陆的时间
	public U_Limit getU_LimitByu_limit(int u_limit);//根据用户权限查询权限表对象
	public boolean updateU_picpath(String path,int u_id);//修改用户头像路劲
	public String getU_picpathByU_id(int u_id);//获取用户头像路劲
	}
