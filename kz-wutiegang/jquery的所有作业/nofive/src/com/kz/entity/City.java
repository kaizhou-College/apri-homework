package com.kz.entity;

public class City {
	private Integer cid;
	private String cname;
	private Integer pid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "city [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}
	
}
