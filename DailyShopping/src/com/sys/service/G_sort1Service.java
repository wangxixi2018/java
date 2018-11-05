package com.sys.service;

import java.util.List;

import com.sys.model.G_sort1;

/**
 * 商品类型刀层接口
 * 
 * @author Administrator
 *
 */
public interface G_sort1Service {
	/**
	 * 添加商品类型
	 */
	int addG_sort1(String G_sort1);

	/**
	 * 删除商品类型
	 * 
	 */
	int delG_sort1(String g_sName);

	/**
	 * 修改商品类型
	 */
	int updateG_sort1(int G_sort1ID, String g_sName);

	/**
	 * 查询所有商品类型
	 */
	List<G_sort1> queryG_sort1();

	/**
	 * 查询指定商品类型
	 */
	public G_sort1 getG_sort1ById(int g_sort1ID);
}
