package com.sys.service;

import java.util.List;

import com.sys.model.G_Size;

/**
 * 商品规格Service 业务层接口
 * 
 * @author Administrator
 *
 */
public interface G_SizeService {
	/**
	 * 添加商品规格
	 */
	int addG_Size(String g_Size);

	/**
	 * 删除商品规格
	 * 
	 */
	int delG_Size(String g_Size);

	/**
	 * 修改商品规格
	 */
	int updateG_Size(int g_sizeID, String g_Size);

	/**
	 * 查询所有商品规格
	 */
	List<G_Size> queryG_Size();

	/**
	 * 查询指定商品规格
	 */
	G_Size getG_SizeById(int g_sizeID);
}
