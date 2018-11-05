package com.sys.dao;

import java.util.List;

import com.sys.model.U_Login;

public interface U_LoginDao {
	//增加
	public int addU_Login(U_Login u_login);
	//删除
	public int deleteU_Login(int u_ID);
	//修改
	public int updateU_Login(U_Login u_login);
	//查询
	public List<U_Login> findU_Login();
	//通过登陆名查询(登陆)
	public U_Login getUserByName(String u_loginName);
	//通過u_id查詢
	public List<U_Login> findU_LoginByu_id(int u_id);
}
