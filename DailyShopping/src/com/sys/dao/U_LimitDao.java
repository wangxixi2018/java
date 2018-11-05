package com.sys.dao;

import java.util.List;

import com.sys.model.U_Limit;

//用户权限
public interface U_LimitDao {
	//增加权限
	public int addu_limit(U_Limit u_limit);
	//删除
	public int deleteu_limit(int u_LimitID);
	//修改
	public int updateu_limit(U_Limit u_limit);
	//查询
	public List<U_Limit> findu_limit();
	//通过用户权限字段号查询
	public U_Limit getLimitByu_limit(int u_limit);
}
