package com.sys.service;

import java.util.List;

import com.sys.model.G_rank;

/**
 * 商品展示区域刀层接口
 * 
 * @author Administrator
 *
 */
public interface G_rankService {
	/**
	 * 添加商品展示区域
	 */
	int addG_rank(String G_rank);

	/**
	 * 删除商品展示区域
	 * 
	 */
	int delG_rank(String g_rankname);

	/**
	 * 修改商品展示区域
	 */
	int updateG_rank(int G_rankID, String g_rankname);

	/**
	 * 查询所有商品展示区域
	 */
	List<G_rank> queryG_rank();
}
