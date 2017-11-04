package com.kz.entity;

public class HouseView extends House {
	/*业务需求 在表没有中没有对应的字段*/
	private String districtStreet;
	/*在jsp页面显示的房屋类型*/
	private String typeView;
	
	public String getTypeView() {
		return typeView;
	}
	public void setTypeView(String typeView) {
		this.typeView = typeView;
	}
	public String getDistrictStreet() {
		return districtStreet;
	}
	public void setDistrictStreet(String districtStreet) {
		this.districtStreet = districtStreet;
	}
	@Override
	public String toString() {
		return "HouseView [districtStreet=" + districtStreet + ", typeView="
				+ typeView + "]"+super.toString();
	}
	
}
