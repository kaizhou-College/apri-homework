package com.kz.entity;

public class QueryHouse extends House{
	/*-1:不限   1:100元以下  2:100元-200元   3:200元以上*/
	private int queryPrice;
	private String street;
	private String type;
	/*-1:不限   1:40元以下  2:40元-500元   3:500元以上*/
	private int area;
	
	
	@Override
	public String toString() {
		return "QueryHouse [area=" + area + ", queryPrice=" + queryPrice
				+ ", street=" + street + ", type=" + type + "]";
	}
	public int getQueryPrice() {
		return queryPrice;
	}
	public void setQueryPrice(int queryPrice) {
		this.queryPrice = queryPrice;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	
}
