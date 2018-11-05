package com.sys.model;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private int age;
	private char sex;
	private int score;
	private Date date;
	public Student(int id, String name, int age, char sex, int score, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.score = score;
		this.date = date;
	}
	public int getId() {
		return id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", score=" + score + ", date="
				+ date + "]";
	}

}
