package com.wtg.entity;

public class QueryHouse extends House{
	//����ͻ���Ҫ��ѯ�ļ۸񣬷���λ�ã����ͣ�������ĸ�����
	//���ݼ۸�
	private int queryPrice;
	//���ݵ�ַ��λ�ã�
	private String address;
	//����
	private String housemodal;
	//���
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
