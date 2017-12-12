package com.kz.entity;

public class User {
	private String uname;
	private String upwd;
	private String usex;
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
	@Override
	public String toString() {
		return "User [uname=" + uname + ", upwd=" + upwd + ", usex=" + usex
				+ "]";
	}
	
}
