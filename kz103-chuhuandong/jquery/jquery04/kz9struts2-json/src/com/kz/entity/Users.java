package com.kz.entity;

public class Users {
	private String uname;
	private String upwd;
	private String usex;
	
	@Override
	public String toString() {
		return "Users [uname=" + uname + ", upwd=" + upwd + ", usex=" + usex
				+ "]";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	
}
