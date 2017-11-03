package com.kz.entity;

public class QueryHouse extends House{
	/*-1:����   1:100Ԫ����  2:100Ԫ-200Ԫ   3:200Ԫ����*/
	private int queryPrice;
	private String street;
	private String type;
	/*-1:����   1:40Ԫ����  2:40Ԫ-500Ԫ   3:500Ԫ����*/
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
