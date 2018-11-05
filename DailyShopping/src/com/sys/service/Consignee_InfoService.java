package com.sys.service;

import java.util.List;

import com.sys.model.Consignee_Information;

public interface Consignee_InfoService {
	public boolean addConsignee_Info(Consignee_Information consignee_information);//添加
	public boolean delConsignee_Info(int o_takeSiteID);//删除
	public boolean updateConsignee_Info(Consignee_Information consignee_information);//修改
	public List<Consignee_Information> getAllConsignee_Info();//查询
	public List<Consignee_Information> getConsignee_InfoByU_Id(int u_id);//通过用户id查询
	public Consignee_Information getConsignee_InfoById(int o_takeSiteID);
}
