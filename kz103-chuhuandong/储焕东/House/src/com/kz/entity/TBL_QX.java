package com.kz.entity;

public class TBL_QX {
	private int qxid;
	private String qx;
	public TBL_QX(int qxid, String qx) {
		super();
		this.qxid = qxid;
		this.qx = qx;
	}
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}
	public TBL_QX() {
		super();
	}
	@Override
	public String toString() {
		return "TBL_QX [qx=" + qx + ", qxid=" + qxid + "]";
	}
}
