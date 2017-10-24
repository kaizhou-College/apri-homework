package com.kz.entity;

public class Users {
	public String name;
	public String pwd;
	public String Date;
	public Users(String name, String pwd, String date) {
		super();
		this.name = name;
		this.pwd = pwd;
		Date = date;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "Users [Date=" + Date + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
}
