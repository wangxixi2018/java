package com.sys.dao;
/**
 * Dao层接口
 */
import java.util.List;



import com.sys.pojo.Khgl;
import com.sys.son.GcmcSon;

public interface KhglDao {
	/**
	 * 查询所有客户
	 * @return
	 */
   public List<Khgl> getKhgls()throws Exception;
   /**
    * 通过工程id查询指定的客户信息
    * @param id
    * @return
    */                 
   public List<GcmcSon> getGcId(int id)throws Exception;
}
