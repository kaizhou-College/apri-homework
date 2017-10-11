package com.kz.entity;

public class role {
	private String name;
	private String id;
	public role(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public role() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
