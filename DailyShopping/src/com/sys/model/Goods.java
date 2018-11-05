package com.sys.model;

import java.io.Serializable;

/**
 * 商品类
 * 
 * @author Administrator
 *
 */

public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int g_ID;
	private int g_sort1ID;
	private int g_sort2ID;
	private int g_sonID;
	private int g_colorsID;
	private int g_sizeID;
	private int g_integral;
	private Double g_g_price;
	private String g_src;
	private int g_rankID;

	public int getG_ID() {
		return g_ID;
	}

	public void setG_ID(int g_ID) {
		this.g_ID = g_ID;
	}

	public int getG_sort1ID() {
		return g_sort1ID;
	}

	public void setG_sort1ID(int g_sort1ID) {
		this.g_sort1ID = g_sort1ID;
	}

	public int getG_sort2ID() {
		return g_sort2ID;
	}

	public void setG_sort2ID(int G_sort2ID) {
		this.g_sort2ID = G_sort2ID;
	}

	public int getG_sonID() {
		return g_sonID;
	}

	public void setG_sonID(int g_sonID) {
		this.g_sonID = g_sonID;
	}

	public int getG_colorsID() {
		return g_colorsID;
	}

	public void setG_colorsID(int g_colorsID) {
		this.g_colorsID = g_colorsID;
	}

	public int getG_sizeID() {
		return g_sizeID;
	}

	public void setG_sizeID(int g_sizeID) {
		this.g_sizeID = g_sizeID;
	}

	public int getG_integral() {
		return g_integral;
	}

	public void setG_integral(int g_integral) {
		this.g_integral = g_integral;
	}

	public double getG_g_price() {
		return g_g_price;
	}

	public void setG_g_price(double g_g_price) {
		this.g_g_price = g_g_price;
	}

	public String getG_src() {
		return g_src;
	}

	public void setG_src(String g_src) {
		this.g_src = g_src;
	}

	public int getG_rankID() {
		return g_rankID;
	}

	public void setG_rankID(int g_rankID) {
		this.g_rankID = g_rankID;
	}

	@Override
	public String toString() {
		return "Goods [g_ID=" + g_ID + ", G_sort1ID=" + g_sort1ID + ", G_sort2ID=" + g_sort2ID + ", g_sonID=" + g_sonID
				+ ", g_colorsID=" + g_colorsID + ", g_sizeID=" + g_sizeID + ", g_integral=" + g_integral
				+ ", g_g_price=" + g_g_price + ", g_src=" + g_src + ", g_rankID=" + g_rankID + "]";
	}

}
