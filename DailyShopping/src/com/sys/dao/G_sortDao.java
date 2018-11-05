package com.sys.dao;

import java.util.List;

import com.sys.model.G_sort;

/**
 * 商品类型刀层接口
 * 
 * @author Administrator
 *
 */
public interface G_sortDao {
	/**
	 * 添加商品类型
	 */
	int addG_sort(String G_sort);

	/**
	 * 删除商品类型
	 * 
	 */
	int delG_sort(String g_sName);

	/**
	 * 修改商品类型
	 */
	int updateG_sort(int G_sortID, String g_sName);

	/**
	 * 查询所有商品类型
	 */
	List<G_sort> queryG_sort();
}
