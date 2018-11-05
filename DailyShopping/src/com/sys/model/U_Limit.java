package com.sys.model;

import java.io.Serializable;

public class U_Limit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_LimitID;//id
	private String u_LimitName;//权限名
	private int u_LimitNumber;//权限号
	public int getU_LimitID() {
		return u_LimitID;
	}
	public void setU_LimitID(int u_LimitID) {
		this.u_LimitID = u_LimitID;
	}
	public String getU_LimitName() {
		return u_LimitName;
	}
	public void setU_LimitName(String u_LimitName) {
		this.u_LimitName = u_LimitName;
	}
	public int getU_LimitNumber() {
		return u_LimitNumber;
	}
	public void setU_LimitNumber(int u_LimitNumber) {
		this.u_LimitNumber = u_LimitNumber;
	}
	
	
}
