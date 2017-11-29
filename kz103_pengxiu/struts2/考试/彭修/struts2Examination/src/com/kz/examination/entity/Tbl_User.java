package com.kz.examination.entity;

public class Tbl_User {
	private Integer uuid;// number primary key,
	private String uname;// varchar2(50) NOT NULL,
	private String upass;// varchar2(50) NOT NULL,
	public Tbl_User(Integer uuid, String uname, String upass) {
		super();
		this.uuid = uuid;
		this.uname = uname;
		this.upass = upass;
	}
	public Tbl_User() {
		super();
		// TODO Auto-generated constructor stub
	}
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
		return "TBL_USER [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	}
	
}
