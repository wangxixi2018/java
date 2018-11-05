package com.sys.service;

import java.util.List;

import com.sys.model.G_son;

/**
 * 商品品牌刀层接口
 * 
 * @author Administrator
 *
 */
public interface G_sonService {
	/**
	 * 添加商品品牌
	 */
	int addG_son(String G_son, String g_describe);

	/**
	 * 删除商品品牌
	 * 
	 */
	int delG_son(int g_sonID);

	/**
	 * 修改商品品牌
	 */
	int updateG_son(int G_sonID, G_son G_son);

	/**
	 * 查询所有商品品牌
	 */
	List<G_son> queryG_son();

	/**
	 * 查询指定的商品品牌
	 */
	List<G_son> queryG_son(int G_sonID);
}
