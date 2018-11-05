package com.sys.model;

public class News {
	private int n_Id;
	private int n_sortid;
	private String n_title;
	private String n_content;
	public int getN_Id() {
		return n_Id;
	}
	public void setN_Id(int n_Id) {
		this.n_Id = n_Id;
	}
	public int getN_sortid() {
		return n_sortid;
	}
	public void setN_sortid(int n_sortid) {
		this.n_sortid = n_sortid;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	@Override
	public String toString() {
		return "News [n_Id=" + n_Id + ", n_sortid=" + n_sortid + ", n_title=" + n_title + ", n_content=" + n_content
				+ "]";
	}
}
