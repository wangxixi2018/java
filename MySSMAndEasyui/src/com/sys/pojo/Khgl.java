package com.sys.pojo;
/**
 * khgl（客户管理）实体类
 * @author Administrator
 *
 */
public class Khgl {
     private int khmc_id;
     private String khmc_name;
	public int getKhmc_id() {
		return khmc_id;
	}
	public void setKhmc_id(int khmc_id) {
		this.khmc_id = khmc_id;
	}
	public String getKhmc_name() {
		return khmc_name;
	}
	public void setKhmc_name(String khmc_name) {
		this.khmc_name = khmc_name;
	}
	@Override
	public String toString() {
		return "Khgl [khmc_id=" + khmc_id + ", khmc_name=" + khmc_name + "]";
	}
     
}
