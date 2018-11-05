package com.sys.model;

import java.io.Serializable;

public class S_Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int s_carId;//id
	private int g_id;//商品id
	private String g_name;//商品（品牌）名称
	private String g_color;//商品颜色
	private String g_size;//商品规格尺寸
	private String g_sortofsex;//按性别分类
	private String g_sortofstyle;//按种类分类
	private double g_price;//商品单价
	private int g_integral;//商品积分
	private int u_id;//用户id
	private int goods_count;//商品数量
	
	
	public double getG_price() {
		return g_price;
	}
	public void setG_price(double g_price) {
		this.g_price = g_price;
	}
	public int getG_integral() {
		return g_integral;
	}
	public void setG_integral(int g_integral) {
		this.g_integral = g_integral;
	}
	public String getG_sortofsex() {
		return g_sortofsex;
	}
	public void setG_sortofsex(String g_sortofsex) {
		this.g_sortofsex = g_sortofsex;
	}
	public String getG_sortofstyle() {
		return g_sortofstyle;
	}
	public void setG_sortofstyle(String g_sortofstyle) {
		this.g_sortofstyle = g_sortofstyle;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_color() {
		return g_color;
	}
	public void setG_color(String g_color) {
		this.g_color = g_color;
	}
	public String getG_size() {
		return g_size;
	}
	public void setG_size(String g_size) {
		this.g_size = g_size;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
	public int getS_carId() {
		return s_carId;
	}
	public void setS_carId(int s_carId) {
		this.s_carId = s_carId;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
}
