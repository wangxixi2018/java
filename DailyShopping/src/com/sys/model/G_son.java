package com.sys.model;

import java.io.Serializable;

/**
 * 商品品牌 类
 * 
 * @author Administrator
 *
 */
public class G_son implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int g_sonID;
	private String g_sName;
	private String g_describe;

	public int getG_sonID() {
		return g_sonID;
	}

	public void setG_sonID(int g_sonID) {
		this.g_sonID = g_sonID;
	}

	public String getG_sName() {
		return g_sName;
	}

	public void setG_sName(String g_sName) {
		this.g_sName = g_sName;
	}

	public String getG_describe() {
		return g_describe;
	}

	public void setG_describe(String g_describe) {
		this.g_describe = g_describe;
	}

	@Override
	public String toString() {
		return "G_son [g_sonID=" + g_sonID + ", g_sName=" + g_sName + ", g_describe=" + g_describe + "]";
	}

}
