package com.wtg.entity;

public class Student {
	private int age;
	private String name;
	private String sex;
	private String address;
	@Override
	public String toString() {
		return "Student [address=" + address + ", age=" + age + ", name="
				+ name + ", sex=" + sex + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
