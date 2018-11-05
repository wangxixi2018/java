package com.sys.model;

import java.io.Serializable;
//订单详情表
public class Order_Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int o_InfoId;//id
	private int g_id;//商品id
	private double o_price;//商品单价
	private double o_totalprice;//单项小记
	private int o_status;//单独订单状态
	private int orderId;//订单总表id
	private String o_time;//单项订单状态改变时间
	private int o_count;//单项订单商品数量
	private String order_son_number;//子订单号
	
	public int getO_InfoId() {
		return o_InfoId;
	}
	public void setO_InfoId(int o_InfoId) {
		this.o_InfoId = o_InfoId;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public double getO_price() {
		return o_price;
	}
	public void setO_price(double o_price) {
		this.o_price = o_price;
	}
	public double getO_totalprice() {
		return o_totalprice;
	}
	public void setO_totalprice(double o_totalprice) {
		this.o_totalprice = o_totalprice;
	}
	public int getO_status() {
		return o_status;
	}
	public void setO_status(int o_status) {
		this.o_status = o_status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}
	public int getO_count() {
		return o_count;
	}
	public void setO_count(int o_count) {
		this.o_count = o_count;
	}
	public String getOrder_son_number() {
		return order_son_number;
	}
	public void setOrder_son_number(String order_son_number) {
		this.order_son_number = order_son_number;
	}
	
}
