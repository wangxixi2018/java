package com.sys.model;

import java.io.Serializable;

/**
 * 商品规格类
 * 
 * @author Administrator
 *
 */
public class G_Size implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int g_sizeID;
	private String g_size;

	public int getG_sizeID() {
		return g_sizeID;
	}

	public void setG_sizeID(int g_sizeID) {
		this.g_sizeID = g_sizeID;
	}

	public String getG_size() {
		return g_size;
	}

	public void setG_size(String g_size) {
		this.g_size = g_size;
	}

	@Override
	public String toString() {
		return "G_Size [g_sizeID=" + g_sizeID + ", g_size=" + g_size + "]";
	}

}
