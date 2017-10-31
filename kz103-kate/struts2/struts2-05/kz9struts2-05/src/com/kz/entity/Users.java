package com.kz.entity;

import java.util.Date;

public class Users {
	private String uname;
	private String upwd;
	private int age;
	private Date birthday;
	private double salary;/*нˮ*/
	
	@Override
	public String toString() {
		return "Users [age=" + age + ", birthday=" + birthday + ", salary="
				+ salary + ", uname=" + uname + ", upwd=" + upwd + "]";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
