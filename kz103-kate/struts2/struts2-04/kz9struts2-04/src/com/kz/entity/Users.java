package com.kz.entity;

import java.util.Arrays;

public class Users {
	private String id;
	private String name;
	private int age;
	private String[] hobbies;//爱好
	//构造方法写了有参数的一定要写无参数(规矩)
	
	
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [age=" + age + ", hobbies=" + Arrays.toString(hobbies)
				+ ", id=" + id + ", name=" + name + "]";
	}
	public Users(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
}
