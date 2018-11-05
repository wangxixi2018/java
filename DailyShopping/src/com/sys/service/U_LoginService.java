package com.sys.service;

import java.util.List;

import com.sys.model.U_Login;
import com.sys.model.User;

public interface U_LoginService {
	public boolean addU_login(User user);//添加登陸表
	public boolean delU_login(int u_id);//刪除
	public boolean updateU_login(U_Login u_login);//修改
	public List<U_Login> findAllU_Login();//查詢所有
	public List<U_Login> findU_LoginByU_Id(int u_id);//通過u_id查詢
}
