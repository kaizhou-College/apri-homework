package com.kz.entity;
//属性名尽量与表的字段名保持一致
public class Users {
	private int uuid;
	private String uname;
	private String sex;
	private double salary;
	private int age;
	
	@Override
	public String toString() {
		return "Users [age=" + age + ", salary=" + salary + ", sex=" + sex
				+ ", uname=" + uname + ", uuid=" + uuid + "]";
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
