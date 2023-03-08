package com.ly.entity;

public class Workers {
	public Workers() {};
	private String username;
	private String department;
	private String position;
	private int userid;
	private int date;
	private int age;
	
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}