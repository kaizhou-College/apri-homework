package com.kz.entity;

public class HouseView extends House {
	/*ҵ������ �ڱ�û����û�ж�Ӧ���ֶ�*/
	private String districtStreet;
	/*��jspҳ����ʾ�ķ�������*/
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
