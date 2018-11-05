package com.sys.dao;

import java.util.List;

import com.sys.model.G_sort2;

/**
 * 商品类型刀层接口
 * 
 * @author Administrator
 *
 */
public interface G_sort2Dao {
	/**
	 * 添加商品类型
	 */
	int addG_sort2(String G_sort2);

	/**
	 * 删除商品类型
	 * 
	 */
	int delG_sort2(String g_sName);

	/**
	 * 修改商品类型
	 */
	int updateG_sort2(int G_sort2ID, String g_sName);

	/**
	 * 查询所有商品类型
	 */
	List<G_sort2> queryG_sort2();

	/**
	 * 查询指定商品类型
	 */
	G_sort2 getG_sort2ById(int g_sort2ID);
}
