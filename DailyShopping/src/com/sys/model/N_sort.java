package com.sys.model;

public class N_sort {
	private int n_SortId;
	private String n_SortName;
	public int getN_SortId() {
		return n_SortId;
	}
	public void setN_SortId(int n_SortId) {
		this.n_SortId = n_SortId;
	}
	public String getN_SortName() {
		return n_SortName;
	}
	public void setN_SortName(String n_SortName) {
		this.n_SortName = n_SortName;
	}
	@Override
	public String toString() {
		return "N_sort [n_SortId=" + n_SortId + ", n_SortName=" + n_SortName + "]";
	}
}
