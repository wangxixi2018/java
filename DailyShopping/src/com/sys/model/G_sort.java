package com.sys.model;

import java.io.Serializable;

/**
 * 商品类型 类
 * 
 * @author Administrator
 *
 */
public class G_sort implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getG_sortID() {
		return g_sortID;
	}

	public void setG_sortID(int g_sortID) {
		this.g_sortID = g_sortID;
	}

	public String getG_sName() {
		return g_sName;
	}

	public void setG_sName(String g_sName) {
		this.g_sName = g_sName;
	}

	private int g_sortID;
	private String g_sName;

	@Override
	public String toString() {
		return "G_sort [g_sortID=" + g_sortID + ", g_sName=" + g_sName + "]";
	}
}
