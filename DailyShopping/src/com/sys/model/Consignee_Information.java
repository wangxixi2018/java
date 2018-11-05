package com.sys.model;

import java.io.Serializable;

//收货信息
public class Consignee_Information implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int o_takeSiteID;//id
	private String o_name;//收货人姓名
	private String o_phone;//收货人电话
	private String o_add;//详细地址
	private String o_area;//地区
	private int u_id;//用户id
	private String o_code;//邮编
	private int u_default_add;//是否是默认收货地址，1表示是，0 表示否
	
	public int getU_default_add() {
		return u_default_add;
	}
	public void setU_default_add(int u_default_add) {
		this.u_default_add = u_default_add;
	}
	public int getO_takeSiteID() {
		return o_takeSiteID;
	}
	public void setO_takeSiteID(int o_takeSiteID) {
		this.o_takeSiteID = o_takeSiteID;
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
	public String getO_add() {
		return o_add;
	}
	public void setO_add(String o_add) {
		this.o_add = o_add;
	}
	public String getO_area() {
		return o_area;
	}
	public void setO_area(String o_area) {
		this.o_area = o_area;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getO_code() {
		return o_code;
	}
	public void setO_code(String o_code) {
		this.o_code = o_code;
	}
}
