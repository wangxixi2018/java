package com.sys.dao;

/**
 * 商品刀层接口
 */
import java.util.List;

import com.sys.model.Goods;

public interface GoodsDao {
	/**
	 * 添加商品
	 */
	int addGoods(Goods Goods);

	/**
	 * 删除商品
	 * 
	 */
	int delGoods(int g_ID);

	/**
	 * 修改商品
	 */
	int updateGoods(int g_ID, Goods Goods);

	/**
	 * 查询所有商品
	 */
	List<Goods> queryGoods();

	/**
	 * 查询指定商品
	 */
	List<Goods> queryGoods(int g_ID);

	/**
	 * 查询指定品牌的所有产品
	 */
	List<Goods> queryGoodsg_sonID(int g_sonID);

	/**
	 * 查询指定类型1的所有品牌
	 */
	List<Goods> queryGoodsg_sort1ID(int g_sort1ID);

	/**
	 * 查询指定类型2的所有商品
	 */
	List<Goods> queryGoodsg_sort2ID(int g_sort2ID);

	/**
	 * 按价格查询指定类型的产品(降序) sort
	 */
	List<Goods> queryGoodsg_g_priceDown(int g_sort2ID);

	/**
	 * 按价格查询指定类型的产品(升序)sort
	 */
	List<Goods> queryGoodsg_g_priceUp(int g_sort2ID);

	/**
	 * 按价格查询指定类型的产品(降序) son
	 */
	List<Goods> queryGoodsg_g_priceSonDown(int g_sonID);

	/**
	 * 按价格查询指定类型的产品(升序) son
	 */
	List<Goods> queryGoodsg_g_priceSonUp(int g_sonID);

	/**
	 * 按颜色找商品
	 */
	List<Goods> queryGoodsColors(Goods goods);

	/**
	 * 详情商品页面后备展示多个图片区 查询
	 * 
	 */
	List<Goods> queryGoodsSrc(Goods goods);

	/**
	 * 查询指定类型的所有颜色
	 * 
	 * @param goods
	 * @return
	 */
	List<Goods> queryGoodsort(Goods goods);

}
