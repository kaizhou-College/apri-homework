package com.kzxy.entity;

public class TBL_SF {
	private Integer sfid;
	private String sf;
	public TBL_SF(Integer sfid, String sf) {
		super();
		this.sfid = sfid;
		this.sf = sf;
	}
	public TBL_SF() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getSfid() {
		return sfid;
	}
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	public String getSf() {
		return sf;
	}
	public void setSf(String sf) {
		this.sf = sf;
	}
	@Override
	public String toString() {
		return "TBL_SF [sf=" + sf + ", sfid=" + sfid + "]";
	}
	
}
