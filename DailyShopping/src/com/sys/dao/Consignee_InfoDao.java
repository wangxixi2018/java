package com.sys.dao;

import java.util.List;

import com.sys.model.Consignee_Information;

public interface Consignee_InfoDao {
	public int addConsignee_Info(Consignee_Information consignee_information);//添加
	public int delConsignee_Info(int o_takeSiteID);//删除
	public int updateConsignee_Info(Consignee_Information consignee_information);//修改
	public List<Consignee_Information> findAllConsignee_Info();//查询
	public List<Consignee_Information> findConsignee_InfoByU_Id(int u_id);//通过用户id查询
	public Consignee_Information fidConsignee_InfoById(int o_takeSiteID);
}
