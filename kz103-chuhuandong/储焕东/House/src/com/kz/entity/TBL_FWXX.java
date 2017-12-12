package com.kz.entity;

public class TBL_FWXX {
	private int fwid;
	private int uuid;
	private int jdid;
	private int lxid;
	private int shi;
	private int ting;
	private String fwxx;
	private double zj;
	private String title;
	private String publishdate;
	private String telephone;
	private String lxr;
	public TBL_FWXX(int fwid, int uuid, int jdid, int lxid, int shi, int ting,
			String fwxx, double zj, String title, String publishdate,
			String telephone, String lxr) {
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
	@Override
	public String toString() {
		return "TBL_FWXX [fwid=" + fwid + ", fwxx=" + fwxx + ", jdid=" + jdid
				+ ", lxid=" + lxid + ", lxr=" + lxr + ", publishdate="
				+ publishdate + ", shi=" + shi + ", telephone=" + telephone
				+ ", ting=" + ting + ", title=" + title + ", uuid=" + uuid
				+ ", zj=" + zj + "]";
	}
	public TBL_FWXX() {
		super();
	}
	public int getFwid() {
		return fwid;
	}
	public void setFwid(int fwid) {
		this.fwid = fwid;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
	public int getShi() {
		return shi;
	}
	public void setShi(int shi) {
		this.shi = shi;
	}
	public int getTing() {
		return ting;
	}
	public void setTing(int ting) {
		this.ting = ting;
	}
	public String getFwxx() {
		return fwxx;
	}
	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}
	public double getZj() {
		return zj;
	}
	public void setZj(double zj) {
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
}
