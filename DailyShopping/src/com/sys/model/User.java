package com.sys.model;

import java.io.Serializable;
import java.util.List;
//用户
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int u_id;//用戶表id
	private String u_loginName;//登录账户
	private String u_loginPwd;//登录密码
	private List<S_Car> s_car;//购物车集合
	private int u_infoId;//用户详情ID
	private int u_loginId;//用户登录ID
	private String u_nc;//用户昵称
	private int u_integral;//用户积分
	private double u_money;//用户账户余额
	private String u_realName;//用户真实姓名
	private int u_age;//用户年龄
	private String u_sex;//用户性别
	private String u_phone;//用户电话
	private String u_papers;//用户身份证号码
	private String u_address;//用户住址
	private String u_email;//用户邮箱
	private int u_limit;//用户权限
	private String u_registration_time;//用户注册时间
	private String u_lastlogin_time;//用户最近一次登陆时间
	private String show_u_id;//页面展示的用户id
	private String u_path;//用户头像路劲
	private List<Receipt_information> receipt_information;//用户收货信息库
	
	
	public double getU_money() {
		return u_money;
	}
	public void setU_money(double u_money) {
		this.u_money = u_money;
	}
	public String getU_path() {
		return u_path;
	}
	public void setU_path(String u_path) {
		this.u_path = u_path;
	}
	public String getShow_u_id() {
		return show_u_id;
	}
	public void setShow_u_id(String show_u_id) {
		this.show_u_id = show_u_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_loginName() {
		return u_loginName;
	}
	public void setU_loginName(String u_loginName) {
		this.u_loginName = u_loginName;
	}
	public String getU_loginPwd() {
		return u_loginPwd;
	}
	public void setU_loginPwd(String u_loginPwd) {
		this.u_loginPwd = u_loginPwd;
	}
	public List<S_Car> getS_car() {
		return s_car;
	}
	public void setS_car(List<S_Car> s_car) {
		this.s_car = s_car;
	}
	public int getU_infoId() {
		return u_infoId;
	}
	public void setU_infoId(int u_infoId) {
		this.u_infoId = u_infoId;
	}
	public int getU_loginId() {
		return u_loginId;
	}
	public void setU_loginId(int u_loginId) {
		this.u_loginId = u_loginId;
	}
	public String getU_nc() {
		return u_nc;
	}
	public void setU_nc(String u_nc) {
		this.u_nc = u_nc;
	}
	public int getU_integral() {
		return u_integral;
	}
	public void setU_integral(int u_integral) {
		this.u_integral = u_integral;
	}
	public String getU_realName() {
		return u_realName;
	}
	public void setU_realName(String u_realName) {
		this.u_realName = u_realName;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_papers() {
		return u_papers;
	}
	public void setU_papers(String u_papers) {
		this.u_papers = u_papers;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public List<Receipt_information> getReceipt_information() {
		return receipt_information;
	}
	public void setReceipt_information(List<Receipt_information> receipt_information) {
		this.receipt_information = receipt_information;
	}
	public int getU_limit() {
		return u_limit;
	}
	public void setU_limit(int u_limit) {
		this.u_limit = u_limit;
	}
	public String getU_registration_time() {
		return u_registration_time;
	}
	public void setU_registration_time(String u_registration_time) {
		this.u_registration_time = u_registration_time;
	}
	public String getU_lastlogin_time() {
		return u_lastlogin_time;
	}
	public void setU_lastlogin_time(String u_lastlogin_time) {
		this.u_lastlogin_time = u_lastlogin_time;
	}
	
}
