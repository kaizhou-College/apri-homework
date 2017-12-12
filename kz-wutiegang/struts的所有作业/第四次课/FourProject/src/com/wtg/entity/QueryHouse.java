package com.wtg.entity;

public class QueryHouse extends House{
	//定义客户需要查询的价格，房屋位置，房型，面积的四个变量
	//房屋价格
	private int queryPrice;
	//房屋地址（位置）
	private String address;
	//房型
	private String housemodal;
	//面积
	private int area;
	
	
	@Override
	public String toString() {
		return "QueryHouse [address=" + address + ", area=" + area
				+ ", housemodal=" + housemodal + ", queryPrice=" + queryPrice
				+ "]";
	}
	public int getQueryPrice() {
		return queryPrice;
	}
	public String getAddress() {
		return address;
	}
	public String getHousemodal() {
		return housemodal;
	}
	public int getArea() {
		return area;
	}
	public void setQueryPrice(int queryPrice) {
		this.queryPrice = queryPrice;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHousemodal(String housemodal) {
		this.housemodal = housemodal;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	
}
