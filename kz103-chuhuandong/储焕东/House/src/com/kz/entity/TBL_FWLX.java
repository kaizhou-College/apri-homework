package com.kz.entity;

public class TBL_FWLX {
	private int lxid;
	private String fwlx;
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public TBL_FWLX(int lxid, String fwlx) {
		super();
		this.lxid = lxid;
		this.fwlx = fwlx;
	}
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
	public TBL_FWLX() {
		super();
	}
	@Override
	public String toString() {
		return "TBL_FWLX [fwlx=" + fwlx + ", lxid=" + lxid + "]";
	}
}
