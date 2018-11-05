package com.sys.service;

import java.util.List;

import com.sys.model.G_Colors;

/**
 * 颜色Service 业务层接口
 * 
 * @author Administrator
 *
 */
public interface G_ColorsService {
	/**
	 * 添加商品颜色
	 */
	int addG_Colors(String colsrs);

	/**
	 * 删除商品颜色
	 * 
	 */
	int delG_Colors(String colsrs);

	/**
	 * 修改商品颜色
	 */
	int updateG_Colors(int g_colorsID, String colsrs);

	/**
	 * 查询所有商品颜色
	 */
	List<G_Colors> queryG_Colors();

	/**
	 * 查询指定颜色
	 */
	List<G_Colors> queryG_Colors(int g_colorsID);
}
