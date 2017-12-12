package com.wtg.entity;

public class AuctionRecord {
	private Integer id;
	private Integer userid;
	private Integer auctionid;
	private String auctiontime;
	private Double auctionprice;
	public Integer getId() {
		return id;
	}
	public Integer getUserid() {
		return userid;
	}
	public Integer getAuctionid() {
		return auctionid;
	}
	public String getAuctiontime() {
		return auctiontime;
	}
	public Double getAuctionprice() {
		return auctionprice;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public void setAuctionid(Integer auctionid) {
		this.auctionid = auctionid;
	}
	public void setAuctiontime(String auctiontime) {
		this.auctiontime = auctiontime;
	}
	public void setAuctionprice(Double auctionprice) {
		this.auctionprice = auctionprice;
	}
	@Override
	public String toString() {
		return "AuctionRecord [auctionid=" + auctionid + ", auctionprice="
				+ auctionprice + ", auctiontime=" + auctiontime + ", id=" + id
				+ ", userid=" + userid + "]";
	}
	
}
