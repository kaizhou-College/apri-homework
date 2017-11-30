package com.kz.entity;

public class Tbl_jd {
	private Integer jdid;
	private String jd;
	private Integer qxid;
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
		return "Tbl_jd [jd=" + jd + ", jdid=" + jdid + ", qxid=" + qxid + "]";
	}
	
	
}
