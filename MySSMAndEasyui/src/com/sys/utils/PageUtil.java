package com.sys.utils;

import java.util.List;

import com.github.pagehelper.Page;
import com.sys.pojo.DatagridLoadFilter;

import net.sf.json.JSONObject;

/*
 * 支持分页功能
 * */
public class PageUtil {
	
	/*将DataGridResult转换成Json，方便后台做检查打印用
	 * [{total:11,rows:[{},{},{}]}]
	 * */
	/**
	 * 后台做检查打印用
	 * @param gridList
	 * @return
	 */
	public static String converList(List<?> gridList){
		JSONObject jo = new JSONObject();
		if(gridList != null){
			if(gridList instanceof Page){
				Page<?> page = (Page<?>) gridList;
				jo.put("total", page.getTotal());
				jo.put("rows", page.getResult());
			}else{
				jo.put("total", gridList.size());
				jo.put("rows", gridList);
			}
		}else{
			jo.put("total", 0);
			jo.put("rows", null);
		}
		return jo.toString();
	}
	
	/**
	 * 返回分页封装数据 total  rows
	 * @param gridList
	 * @return
	 */
	public static DatagridLoadFilter convertToResult(List<?> gridList){
		DatagridLoadFilter dataGrid = null;
		
		if(gridList != null){
			if(gridList instanceof Page){
				Page<?> page = (Page<?>) gridList;
				dataGrid = new DatagridLoadFilter(page.getTotal(),page.getResult());
			}else{
				dataGrid = new DatagridLoadFilter(new Long(gridList.size()),gridList);
			}
		}else{//数据为null
			dataGrid = new DatagridLoadFilter(new Long(0),null); 
		}
		
		return dataGrid;
	}
	
}
