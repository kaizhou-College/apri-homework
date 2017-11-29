package com.kz.examination.entity;

public class TBL_FWXX {
	private Integer fwid;// number primary key,
	private Integer uuid;// number NULL,
	private Integer jdid;// number NULL,
	private Integer lxid;// number NULL,
	private Integer shi;// number NULL,
	private Integer ting;// number NULL,
	private String fwxx;// varchar2(2000) NULL,
	private Integer zj;// number(3,5) NULL,
	private String title;// varchar2(70) NOT NULL,
	private String publishdate;// date NULL,
	private String telephone;// varchar2(50) NULL,
	private String lxr;// varchar2(50) NULL
	
	public TBL_FWXX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TBL_FWXX(Integer fwid, Integer uuid, Integer jdid, Integer lxid,
			Integer shi, Integer ting, String fwxx, Integer zj, String title,
			String publishdate, String telephone, String lxr) {
		super();
		this.fwid = fwid;
		this.uuid = uuid;
		this.jdid = jdid;
		this.lxid = lxid;
		this.shi = shi;
		this.ting = ting;
		this.fwxx = fwxx;
		this.zj = zj;
		this.title = title;
		this.publishdate = publishdate;
		this.telephone = telephone;
		this.lxr = lxr;
	}
	public Integer getFwid() {
		return fwid;
	}
	public void setFwid(Integer fwid) {
		this.fwid = fwid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getJdid() {
		return jdid;
	}
	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}
	public Integer getLxid() {
		return lxid;
	}
	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}
	public Integer getShi() {
		return shi;
	}
	public void setShi(Integer shi) {
		this.shi = shi;
	}
	public Integer getTing() {
		return ting;
	}
	public void setTing(Integer ting) {
		this.ting = ting;
	}
	public String getFwxx() {
		return fwxx;
	}
	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}
	public Integer getZj() {
		return zj;
	}
	public void setZj(Integer zj) {
		this.zj = zj;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	@Override
	public String toString() {
		return "TBL_FWXX [fwid=" + fwid + ", fwxx=" + fwxx + ", jdid=" + jdid
				+ ", lxid=" + lxid + ", lxr=" + lxr + ", publishdate="
				+ publishdate + ", shi=" + shi + ", telephone=" + telephone
				+ ", ting=" + ting + ", title=" + title + ", uuid=" + uuid
				+ ", zj=" + zj + "]";
	}
	
}
