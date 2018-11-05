package com.sys.model;

import java.io.Serializable;

/**
 * 评论类
 * @author xiong
 *
 */
public class Topic implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   private int t_ID;
   private int g_ID;
   private String t_content;
   private String t_time;
   private int u_ID;
public int getT_ID() {
	return t_ID;
}
public void setT_ID(int t_ID) {
	this.t_ID = t_ID;
}
public int getG_ID() {
	return g_ID;
}
public void setG_ID(int g_ID) {
	this.g_ID = g_ID;
}
public String getT_content() {
	return t_content;
}
public void setT_content(String t_content) {
	this.t_content = t_content;
}
public String getT_time() {
	return t_time;
}
public void setT_time(String t_time) {
	this.t_time = t_time;
}
public int getU_ID() {
	return u_ID;
}
public void setU_ID(int u_ID) {
	this.u_ID = u_ID;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
   
}
