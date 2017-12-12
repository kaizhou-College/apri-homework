package com.wtg.entity;
//这是一个放表中没有的变量的一个类，放到那个类中就继承那个类
public class HouseView extends House{
	//多表关联的返回值
	private String ds;
	//类型表里面的东西,用来在jsp中显示房屋类型
	private String type;

	public String getDs() {
		return ds;
	}

	public void setDs(String ds) {
		this.ds = ds;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "HouseView [ds=" + ds + ", type=" + type + "]"+super.toString();
	}
	
	
}
