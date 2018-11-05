package com.sys.model;

import java.io.Serializable;

public class U_Login implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_LoginID;//id
	private String u_LoginName;//登陆账号
	private String u_LoginPwd;//登陆密码
	private int u_ID;//用户id
	
	public int getU_LoginID() {
		return u_LoginID;
	}
	public void setU_LoginID(int u_LoginID) {
		this.u_LoginID = u_LoginID;
	}
	public String getU_LoginName() {
		return u_LoginName;
	}
	public void setU_LoginName(String u_LoginName) {
		this.u_LoginName = u_LoginName;
	}
	public String getU_LoginPwd() {
		return u_LoginPwd;
	}
	public void setU_LoginPwd(String u_LoginPwd) {
		this.u_LoginPwd = u_LoginPwd;
	}
	public int getU_ID() {
		return u_ID;
	}
	public void setU_ID(int u_ID) {
		this.u_ID = u_ID;
	}
	
	
}
