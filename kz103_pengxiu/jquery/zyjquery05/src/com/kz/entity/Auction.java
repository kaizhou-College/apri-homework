package com.kz.entity;

import java.util.HashSet;
import java.util.Vector;

public class Auction {
	private Integer auctionId   ;      //   number(6)                      
    private String  auctionName ;        // nvarchar2(50)               
	private Integer auctionStartPrice  ; /// number(9,2)                  
	private Integer auctionUpset    ;  //   number(9,2)                     
	private String auctionStartTime ; //   TIMESTAMP                    
	private String auctionEndTime  ;  //   TIMESTAMP                       
	private String auctionPic      ;  //   BLOB                          
	private String auctionPicType  ;  //   nvarchar2(20)                  
	private String auctionDesc    ;   //   nvarchar2(500)
	public Auction(Integer auctionId, String auctionName,
			Integer auctionStartPrice, Integer auctionUpset,
			String auctionStartTime, String auctionEndTime, String auctionPic,
			String auctionPicType, String auctionDesc) {
		super();
		this.auctionId = auctionId;
		this.auctionName = auctionName;
		this.auctionStartPrice = auctionStartPrice;
		this.auctionUpset = auctionUpset;
		this.auctionStartTime = auctionStartTime;
		this.auctionEndTime = auctionEndTime;
		this.auctionPic = auctionPic;
		this.auctionPicType = auctionPicType;
		this.auctionDesc = auctionDesc;
	}
	
//	public static void main(String[] args) {
//		Vector newVector = new Vector();
//		newVector.add(1);
//		newVector.add(3);
//		newVector.add(5);
//		newVector.add(2);
//		newVector.add(6);
//		newVector.add(3);
//		newVector.add(10);
//		newVector.add("b");
//		newVector.add("c");
//		newVector.add("a");
//		newVector.add("c");
//		HashSet set = new HashSet(newVector);
//		for (int i = 0; i < set.size(); i++) {
//			System.out.println(set);
//		}
//	}
	
	public Auction(String auctionName, Integer auctionStartPrice,
			String auctionStartTime, String auctionEndTime, String auctionDesc) {
		super();
		this.auctionName = auctionName;
		this.auctionStartPrice = auctionStartPrice;
		this.auctionStartTime = auctionStartTime;
		this.auctionEndTime = auctionEndTime;
		this.auctionDesc = auctionDesc;
	}


	public Auction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public Integer getAuctionStartPrice() {
		return auctionStartPrice;
	}
	public void setAuctionStartPrice(Integer auctionStartPrice) {
		this.auctionStartPrice = auctionStartPrice;
	}
	public Integer getAuctionUpset() {
		return auctionUpset;
	}
	public void setAuctionUpset(Integer auctionUpset) {
		this.auctionUpset = auctionUpset;
	}
	public String getAuctionStartTime() {
		return auctionStartTime;
	}
	public void setAuctionStartTime(String auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}
	public String getAuctionEndTime() {
		return auctionEndTime;
	}
	public void setAuctionEndTime(String auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}
	public String getAuctionPic() {
		return auctionPic;
	}
	public void setAuctionPic(String auctionPic) {
		this.auctionPic = auctionPic;
	}
	public String getAuctionPicType() {
		return auctionPicType;
	}
	public void setAuctionPicType(String auctionPicType) {
		this.auctionPicType = auctionPicType;
	}
	public String getAuctionDesc() {
		return auctionDesc;
	}
	public void setAuctionDesc(String auctionDesc) {
		this.auctionDesc = auctionDesc;
	}
	@Override
	public String toString() {
		return "Auction [auctionDesc=" + auctionDesc + ", auctionEndTime="
				+ auctionEndTime + ", auctionId=" + auctionId
				+ ", auctionName=" + auctionName + ", auctionPic=" + auctionPic
				+ ", auctionPicType=" + auctionPicType + ", auctionStartPrice="
				+ auctionStartPrice + ", auctionStartTime=" + auctionStartTime
				+ ", auctionUpset=" + auctionUpset + "]";
	}
}
