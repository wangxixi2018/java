package com.sys.model;

import java.io.Serializable;

/**
 * 商品类型 类
 * 
 * @author Administrator
 *
 */
public class G_sort1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int g_sort1ID;
	private String g_sName;

	public int getG_sort1ID() {
		return g_sort1ID;
	}

	public void setG_sort1ID(int g_sort1ID) {
		this.g_sort1ID = g_sort1ID;
	}

	public String getG_sName() {
		return g_sName;
	}

	public void setG_sName(String g_sName) {
		this.g_sName = g_sName;
	}

	@Override
	public String toString() {
		return "G_sort1 [G_sort1ID=" + g_sort1ID + ", g_sName=" + g_sName + "]";
	}

}
