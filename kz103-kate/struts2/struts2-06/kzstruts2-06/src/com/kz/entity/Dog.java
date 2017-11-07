package com.kz.entity;

public class Dog {

	private int did;
	
	private String dname;
	

	public Dog() {
		super();
	}
	
	

	public Dog(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}



	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	
}
