package com.kz.entity;
//类名必须和表名一致  属性名必须和字段名一致
//这个类能被克隆，必须要实现cloneable接口
public class Users extends Object implements Cloneable {
	private int id;
	private String uname;
	private int age;
	private String sex;
	private double salary;
	private GirlFriend gf;
	
	@Override
	public String toString() {
		return "Users [age=" + age + ", id=" + id + ", salary=" + salary
				+ ", sex=" + sex + ", uname=" + uname + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public GirlFriend getGf() {
		return gf;
	}
	public void setGf(GirlFriend gf) {
		this.gf = gf;
	}
	public Object clone() throws CloneNotSupportedException {
		//return super.clone();
		
		Users u = (Users) super.clone();
		GirlFriend gf2 = (GirlFriend) this.gf.clone();
		//将克隆的女朋友复制给克隆的User
		u.setGf(gf2);
		
		return u;
	}
	
	 
	
}
