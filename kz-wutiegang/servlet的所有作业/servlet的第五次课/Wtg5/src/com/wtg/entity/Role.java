package com.wtg.entity;

public class Role {
	private String id;
	private String name;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String id, String name) {
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"\t"+name;
	}
}
