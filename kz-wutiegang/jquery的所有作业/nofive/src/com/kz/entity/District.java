package com.kz.entity;

public class District {
	private Integer did;
	private String dname;
	private Integer cid;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "district [cid=" + cid + ", did=" + did + ", dname=" + dname
				+ "]";
	}
	
}
