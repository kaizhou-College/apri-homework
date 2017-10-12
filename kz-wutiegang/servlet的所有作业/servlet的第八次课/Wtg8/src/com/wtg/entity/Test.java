package com.wtg.entity;

public class Test {
	private int age;
	private String name;
	@Override
	public String toString() {
		return "Test [age=" + age + ", name=" + name + "]";
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
	
}
