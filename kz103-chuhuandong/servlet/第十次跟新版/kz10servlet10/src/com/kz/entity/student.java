package com.kz.entity;
import java.io.Serializable;

public class student implements Serializable,Cloneable{
	private String name;
	private int age;
	public student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "student [age=" + age + ", name=" + name + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
