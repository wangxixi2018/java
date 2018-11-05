package com.sys.model;

import java.io.Serializable;

/**
 * 商品类型 类
 * 
 * @author Administrator
 *
 */
public class G_sort2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int g_sort2ID;
	private String g_sName;

	public int getG_sort2ID() {
		return g_sort2ID;
	}

	public void setG_sort2ID(int g_sort2ID) {
		this.g_sort2ID = g_sort2ID;
	}

	public String getG_sName() {
		return g_sName;
	}

	public void setG_sName(String g_sName) {
		this.g_sName = g_sName;
	}

	@Override
	public String toString() {
		return "G_sort2 [g_sort2ID=" + g_sort2ID + ", g_sName=" + g_sName + "]";
	}

}
