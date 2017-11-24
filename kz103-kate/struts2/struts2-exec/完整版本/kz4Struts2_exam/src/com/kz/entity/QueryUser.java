package com.kz.entity;

public class QueryUser extends User{
	//条件的中实体类没有的属性条件
	private String isUpload;

	public String getIsUpload() {
		return isUpload;
	}
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
}
