package com.sys.model;

import java.io.Serializable;
//收货信息
public class Receipt_information implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String o_name;//收货人姓名
	private String o_phone;//收货人电话
	private String o_address;//收货人地址
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
	public String getO_address() {
		return o_address;
	}
	public void setO_address(String o_address) {
		this.o_address = o_address;
	}
	
	
}
