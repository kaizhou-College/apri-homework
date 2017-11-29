package com.kz.examination.entity;

public class TBL_FWLX {
	private Integer lxid;// number primary key,
	private String fwlx;// varchar2(50) NULL,
	
	public TBL_FWLX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TBL_FWLX(Integer lxid, String fwlx) {
		super();
		this.lxid = lxid;
		this.fwlx = fwlx;
	}
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
		return "TBL_FWLX [fwlx=" + fwlx + ", lxid=" + lxid + "]";
	}
	
}
