package com.sys.model;

import java.io.Serializable;

//订单状态表
public class Order_status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int o_statusId;//id
	private String o_statusName;//状态名
	public int getO_statusId() {
		return o_statusId;
	}
	public void setO_statusId(int o_statusId) {
		this.o_statusId = o_statusId;
	}
	public String getO_statusName() {
		return o_statusName;
	}
	public void setO_statusName(String o_statusName) {
		this.o_statusName = o_statusName;
	}
	
	
}
