package com.wtg.entity;

public class User {
	private String uname;
	private String psw;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	@Override
	public String toString() {
		return "User [psw=" + psw + ", uname=" + uname + "]";
	}
	
}
