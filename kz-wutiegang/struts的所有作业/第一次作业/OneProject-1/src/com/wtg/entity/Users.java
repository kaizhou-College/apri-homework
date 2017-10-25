package com.wtg.entity;

public class Users {
	private int uuid;
	private String uname;
	private String upassword;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "Users [uname=" + uname + ", upassword=" + upassword + ", uuid="
				+ uuid + "]";
	}
	public Users(int uuid, String uname, String upassword) {
		super();
		this.uuid = uuid;
		this.uname = uname;
		this.upassword = upassword;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}
	
}
