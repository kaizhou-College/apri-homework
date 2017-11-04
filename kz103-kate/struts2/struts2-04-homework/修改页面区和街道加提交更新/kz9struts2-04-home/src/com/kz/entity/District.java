package com.kz.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

public class District {
	private int id;
	private String name;
	
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
