package entity;

import java.io.Serializable;

public class A implements Serializable{
	private String aname;
	private int aid;
	private int age;
	private String sex;
	public A() {
		super();
	}
	public A(String aname, int aid, int age, String sex) {
		super();
		this.aname = aname;
		this.aid = aid;
		this.age = age;
		this.sex = sex;
	}
	public String toString() {
		return "A [age=" + age + ", aid=" + aid + ", aname=" + aname + ", sex="
				+ sex + "]";
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
}
