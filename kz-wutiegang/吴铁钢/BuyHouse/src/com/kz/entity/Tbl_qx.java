package com.kz.entity;

public class Tbl_qx {
	private Integer qxid;
	private String qx;
	public Integer getQxid() {
		return qxid;
	}
	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}
	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}
	@Override
	public String toString() {
		return "Tbl_qx [qx=" + qx + ", qxid=" + qxid + "]";
	}
	
}
