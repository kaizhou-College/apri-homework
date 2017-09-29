package com.kz.entity;

public class Man {
	private String uname;
	private int age;
	
	
	
	@Override
	public String toString() {
		return "Man [age=" + age + ", uname=" + uname + "]";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
