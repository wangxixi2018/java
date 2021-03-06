package com.sys.dao;

import java.util.List;

import com.sys.model.G_Colors;

/**
 * 商品颜色刀层接口
 * 
 * @author Administrator
 *
 */
public interface G_ColorsDao {
	/**
	 * 添加颜色
	 */
	int addG_Colors(String colsrs);

	/**
	 * 删除颜色
	 * 
	 */
	int delG_Colors(String colsrs);

	/**
	 * 修改颜色
	 */
	int updateG_Colors(int g_colorsID, String colsrs);

	/**
	 * 查询所有颜色
	 */
	List<G_Colors> queryG_Colors();

	/**
	 * 查询指定颜色
	 */
	List<G_Colors> queryG_Colors(int g_colorsID);
}
