package com.kz.entity;

public class Tbl_fwlx {
	private Integer lxid;
	private String fwlx;
	public Integer getLxid() {
		return lxid;
	}
	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	@Override
	public String toString() {
		return "Tbl_fwlx [fwlx=" + fwlx + ", lxid=" + lxid + "]";
	}
	
}
