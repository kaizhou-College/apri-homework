package com.kz.entity;

public class Tbl_user {
	private Integer uuid;
	private String uname;
	private String upass;
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "Tbl_user [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	}
	
	
}
