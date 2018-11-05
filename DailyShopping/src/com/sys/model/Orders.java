package com.sys.model;

import java.io.Serializable;
//订单总表
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderId;//id
	private int o_statusId;//订单状态id
	private String o_status;//订单状态
	private int u_id;//用户id
	private double o_money;//订单总金额
	private String o_add;//订单收货地址
	private String o_name;//收货人姓名
	private String o_phone;//收货电话
	private String order_Time;//下单时间
	private String order_number;//单号
	private String payment;//付款方式
	
	
	public String getO_status() {
		return o_status;
	}
	public void setO_status(String o_status) {
		this.o_status = o_status;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getO_statusId() {
		return o_statusId;
	}
	public void setO_statusId(int o_statusId) {
		this.o_statusId = o_statusId;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public double getO_money() {
		return o_money;
	}
	public void setO_money(double o_money) {
		this.o_money = o_money;
	}
	public String getO_add() {
		return o_add;
	}
	public void setO_add(String o_add) {
		this.o_add = o_add;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getO_phone() {
		return o_phone;
	}
	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}
	public String getOrder_Time() {
		return order_Time;
	}
	public void setOrder_Time(String order_Time) {
		this.order_Time = order_Time;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	
	
}
