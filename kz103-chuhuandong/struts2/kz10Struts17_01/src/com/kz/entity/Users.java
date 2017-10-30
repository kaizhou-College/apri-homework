package com.kz.entity;

import java.util.Date;

public class Users {
	private String name;
	private String pwd;
	private Date brithday;
	public Users(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public Users() {
		super();
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
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	@Override
	public String toString() {
		return "Users [brithday=" + brithday + ", name=" + name + ", pwd="
				+ pwd + "]";
	}
}
