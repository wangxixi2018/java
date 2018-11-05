package com.sys.service.Impl;
/**
 * 工程名称业务层实现类
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.GcmcDao;
import com.sys.pojo.DatagridLoadFilter;
import com.sys.pojo.Gcmc;

import com.sys.service.GcmcService;
import com.sys.son.GcmcSon;
import com.sys.utils.MessageInfo;
import com.sys.utils.PageUtil;

@Service
public class GcmcServiceImpl implements GcmcService {
	@Autowired
    private GcmcDao gcmcDao;
	@Autowired
	private MessageInfo messageInfo;
	@Autowired
	@Qualifier("DatagridLoadFilter")
	private DatagridLoadFilter datagridLoadFilter;
	@Override
	public List<Gcmc> getListGcmc() throws Exception {
		System.out.println("GcmcService 层");
		return gcmcDao.getListGcmc();
	}
	@Override
	public MessageInfo delGcmc(int[] Gcmcid) throws Exception {
		
		if(gcmcDao.delGcmc(Gcmcid)==Gcmcid.length) {
			messageInfo.setFlag(true);
			messageInfo.setMistake("删除成功");
		}else{
			messageInfo.setFlag(false);
			messageInfo.setMistake("删除失败");
		};
		return messageInfo;
	}
	@Override
	public DatagridLoadFilter selectGcmc(String select) throws Exception {
		List<Gcmc> GcmcList=gcmcDao.selectGcmc(select);
		datagridLoadFilter.setRows(GcmcList);
		datagridLoadFilter.setTotal(GcmcList.size());
		return datagridLoadFilter;
	}
	@Override
	public MessageInfo addGcmc(GcmcSon gcmcSon) throws Exception {
		MessageInfo messageInfo=new MessageInfo();
		if(gcmcDao.addGcmc(gcmcSon)==1) {
			messageInfo.setFlag(true);
			messageInfo.setMistake("添加成功");
			System.out.println("!!!!!");
		}else{
			messageInfo.setFlag(false);
			messageInfo.setMistake("添加失败");
		};
		return messageInfo;
	}
	/**
	 * 查询指定用户的所有工程
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override  
	public DatagridLoadFilter getGcId(GcmcSon gcmcSon) throws Exception {
		
		//List<GcmcSon> listKhglSon=khglDao.getGcId(id);
		//分页逻辑
	//查询出来的总数量          展示第几页            页大小
	//情况1. 1000            1           20                     total：1000      rows：20
	//情况2.  0                                                 total 0          rows null
	//情况3. 19                                                 total 19         rows list.size
		
		
	//调动分页工具
		DatagridLoadFilter datagridLoadFilter=PageUtil.convertToResult(gcmcDao.getGcId(gcmcSon));		
		/*datagridLoadFilter.setRows(listKhglSon);
		datagridLoadFilter.setTotal(listKhglSon.size());*/
		return datagridLoadFilter;
	}
}
