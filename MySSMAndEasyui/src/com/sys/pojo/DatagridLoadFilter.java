package com.sys.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 *   Easyui框架返回过滤数据 模板
 * @author Administrator
 *
 */
@Component("DatagridLoadFilter")
public class DatagridLoadFilter {
	/**
	 * 返回总数量(查询出来的总记录数)
	 */
   private long total; //返回总数量(查询出来的总记录数)
   /**
    * //返回数据（当前页数据）
    */
   private List<?> rows; //返回数据（当前页数据）
   
   
	public DatagridLoadFilter() {
	
	// TODO Auto-generated constructor stub
	}
	public DatagridLoadFilter(long total, List<?> rows) {
	
	this.total = total;
	this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	/**
	 * 返回总数量(查询出来的总记录数)
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	/**
	 * 返回数据（当前页数据）
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}  
}
