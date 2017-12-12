package com.wtg.entity;


public class Auction {
	private Integer auctionid;
	private String auctionname;
	private Integer auctionstartprice;
	private Integer auctionupset;
	private String auctionstarttime;
	private String auctionendtime;
	private String auctionpic;
	private String auctionpictype;
	private String auctiondesc;
	public Integer getAuctionid() {
		return auctionid;
	}
	public String getAuctionname() {
		return auctionname;
	}
	public Integer getAuctionstartprice() {
		return auctionstartprice;
	}
	public Integer getAuctionupset() {
		return auctionupset;
	}
	public String getAuctionstarttime() {
		return auctionstarttime;
	}
	public String getAuctionendtime() {
		return auctionendtime;
	}
	public String getAuctionpic() {
		return auctionpic;
	}
	public String getAuctionpictype() {
		return auctionpictype;
	}
	public String getAuctiondesc() {
		return auctiondesc;
	}
	public void setAuctionid(Integer auctionid) {
		this.auctionid = auctionid;
	}
	public void setAuctionname(String auctionname) {
		this.auctionname = auctionname;
	}
	public void setAuctionstartprice(Integer auctionstartprice) {
		this.auctionstartprice = auctionstartprice;
	}
	public void setAuctionupset(Integer auctionupset) {
		this.auctionupset = auctionupset;
	}
	public void setAuctionstarttime(String auctionstarttime) {
		this.auctionstarttime = auctionstarttime;
	}
	public void setAuctionendtime(String auctionendtime) {
		this.auctionendtime = auctionendtime;
	}
	public void setAuctionpic(String auctionpic) {
		this.auctionpic = auctionpic;
	}
	public void setAuctionpictype(String auctionpictype) {
		this.auctionpictype = auctionpictype;
	}
	public void setAuctiondesc(String auctiondesc) {
		this.auctiondesc = auctiondesc;
	}
	@Override
	public String toString() {
		return "Auction [auctiondesc=" + auctiondesc + ", auctionendtime="
				+ auctionendtime + ", auctionid=" + auctionid
				+ ", auctionname=" + auctionname + ", auctionpic=" + auctionpic
				+ ", auctionpictype=" + auctionpictype + ", auctionstartprice="
				+ auctionstartprice + ", auctionstarttime=" + auctionstarttime
				+ ", auctionupset=" + auctionupset + "]";
	}
	
	
}
