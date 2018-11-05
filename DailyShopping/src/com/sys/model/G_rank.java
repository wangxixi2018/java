package com.sys.model;

import java.io.Serializable;

/**
 * 商品展示区域 类
 * 
 * @author Administrator
 *
 */
public class G_rank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int g_rankID;
	private String g_rankname;

	public int getG_rankID() {
		return g_rankID;
	}

	public void setG_rankID(int g_rankID) {
		this.g_rankID = g_rankID;
	}

	public String getG_rankname() {
		return g_rankname;
	}

	public void setG_rankname(String g_rankname) {
		this.g_rankname = g_rankname;
	}

	@Override
	public String toString() {
		return "G_rank [g_rankID=" + g_rankID + ", g_rankname=" + g_rankname + "]";
	}

}
