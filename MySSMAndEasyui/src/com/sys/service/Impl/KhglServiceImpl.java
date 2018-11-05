package com.sys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sys.dao.KhglDao;
import com.sys.pojo.DatagridLoadFilter;
import com.sys.pojo.Khgl;
import com.sys.service.KhglService;
import com.sys.son.GcmcSon;
import com.sys.utils.PageUtil;
/**
 * khgl业务实现类
 * @author Administrator
 *
 */
@Service
public class KhglServiceImpl implements KhglService {
   @Autowired
   private KhglDao khglDao;
	@Override
	public List<Khgl> getKhgls() throws Exception {
		System.out.println("KhglService 层");
		return khglDao.getKhgls();
	}
	@Override  
	public DatagridLoadFilter getGcId(int id) throws Exception {
		System.out.println("id:%%%%%"+id);
		//List<GcmcSon> listKhglSon=khglDao.getGcId(id);
		//分页逻辑
	//查询出来的总数量          展示第几页            页大小
	//情况1. 1000            1           20                     total：1000      rows：20
	//情况2.  0                                                 total 0          rows null
	//情况3. 19                                                 total 19         rows list.size
		
		
	//调动分页工具
		DatagridLoadFilter datagridLoadFilter=PageUtil.convertToResult(khglDao.getGcId(id));		
		/*datagridLoadFilter.setRows(listKhglSon);
		datagridLoadFilter.setTotal(listKhglSon.size());*/
		return datagridLoadFilter;
	}
	
}
