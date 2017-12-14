package com.kzxy.entity;

public class TBL_QX {
	private Integer qxid;// number primary key,
	private String qx;// varchar2(50) NULL,
	
	public TBL_QX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TBL_QX(Integer qxid, String qx) {
		super();
		this.qxid = qxid;
		this.qx = qx;
	}
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
		return "TBL_QX [qx=" + qx + ", qxid=" + qxid + "]";
	}
	
}
