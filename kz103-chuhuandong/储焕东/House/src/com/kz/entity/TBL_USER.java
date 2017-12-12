package com.kz.entity;

public class TBL_USER{
	private int uuid;
	private String uname;
	private String upass;
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
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public TBL_USER(int uuid, String uname, String upass) {
		super();
		this.uuid = uuid;
		this.uname = uname;
		this.upass = upass;
	}
	public TBL_USER() {
		super();
	}
	@Override
	public String toString() {
		return "TBL_USER [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	}
}
