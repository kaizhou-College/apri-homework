package com.kzxy.entity;

public class TBL_JD {
	private Integer jdid;// number primary key,
	private String jd;// varchar2(50) NULL,
	private Integer qxid;
	
	public TBL_JD(Integer jdid, String jd, Integer qxid) {
		super();
		this.jdid = jdid;
		this.jd = jd;
		this.qxid = qxid;
	}
	public TBL_JD() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getJdid() {
		return jdid;
	}
	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	
	public Integer getQxid() {
		return qxid;
	}
	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}
	@Override
	public String toString() {
		return "TBL_JD [jd=" + jd + ", jdid=" + jdid + ", qxid=" + qxid + "]";
	}
	
	

}
