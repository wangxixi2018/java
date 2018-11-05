package com.sys.model;

import java.io.Serializable;

/**
 * 订单收货地址类
 * @author xiong
 *
 */
public class OrdertakeSite implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   private int o_takeSiteID;
   private String o_name;
   private String o_phone;
   private String o_add;
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
public static long getSerialversionuid() {
	return serialVersionUID;
}
   
}
