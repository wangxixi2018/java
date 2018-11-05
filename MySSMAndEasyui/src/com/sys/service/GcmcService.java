package com.sys.service;
/**
 * 工程名称业务层接口
 */
import java.util.List;

import com.sys.pojo.DatagridLoadFilter;
import com.sys.pojo.Gcmc;
import com.sys.son.GcmcSon;
import com.sys.utils.MessageInfo;

public interface GcmcService {
	/**
	 * 查询所有工程名称
	 * @return
	 * @throws Exception
	 */
  public List<Gcmc> getListGcmc()throws Exception;
  /**
   * 删除工程id 单个或多个
   * @param Gcmcid
   * @return
   */
  public MessageInfo delGcmc(int[] Gcmcid)throws Exception;
  /**
   * 模糊查询
   * @param select
   * @return
   * @throws Exception
   */
  public DatagridLoadFilter selectGcmc(String select)throws Exception; 
  /**
   * 添加工程
   * @param gcmcSon
   * @return
   * @throws Exception
   */
  public MessageInfo addGcmc(GcmcSon gcmcSon)throws Exception;
  /**
   * 通过工程id查询指定的客户信息并返回封装的Easyui框架数据到模板类中
   * @param id
   * @return
   */                 
  public DatagridLoadFilter getGcId(GcmcSon gcmcSon)throws Exception;
}
