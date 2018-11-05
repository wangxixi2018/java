package com.sys.service;

import java.util.List;

import com.sys.pojo.DatagridLoadFilter;
import com.sys.pojo.Khgl;


/**
 * 业务层 接口
 * @author Administrator
 *
 */
public interface KhglService {
	/**
	 * 查询所有客户
	 * @return
	 */
    public List<Khgl> getKhgls() throws Exception;
    /**
     * 通过工程id查询指定的客户信息并返回封装的Easyui框架数据到模板类中
     * @param id
     * @return
     */                 
    public DatagridLoadFilter getGcId(int id)throws Exception;
    
}
