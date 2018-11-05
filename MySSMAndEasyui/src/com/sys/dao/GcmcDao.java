package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.pojo.Gcmc;
import com.sys.son.GcmcSon;

/**
 * 工程名称dao接口
 * @author Administrator
 *
 */
public interface GcmcDao {
	/**
	 * 查询所有工程名称
	 * @return
	 * @throws Exception
	 */
  public List<Gcmc> getListGcmc()throws Exception;
  /**
   * 通过工程id查询指定的客户信息
   * @param id
   * @return
   */                 
  public List<GcmcSon> getGcId(GcmcSon gcmcSon)throws Exception;
  /**
   * 删除工程id 单个或多个
   * @param Gcmcid
   * @return
   */
  public int delGcmc(@Param("Gcmcid")int[] Gcmcid)throws Exception;
  /**
   * 修改工程
   * @param gcmc
   * @return
   * @throws Exception
   */
  public int updateGcmc(Gcmc gcmc)throws Exception;
  /**
   * 模糊查询
   * @param select
   * @return
   * @throws Exception
   */
  public List<Gcmc> selectGcmc(String select)throws Exception; 
  /**
   * 添加工程
   * @param gcmcSon
   * @return
   * @throws Exception
   */
  public int addGcmc(GcmcSon gcmcSon)throws Exception;
}
