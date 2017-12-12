package com.wtg.entity;

public class Street {
	private int id;
	private String name;
	private int district_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int districtId) {
		district_id = districtId;
	}
	@Override
	public String toString() {
		return "Street [district_id=" + district_id + ", id=" + id + ", name="
				+ name + "]";
	}
	
}
