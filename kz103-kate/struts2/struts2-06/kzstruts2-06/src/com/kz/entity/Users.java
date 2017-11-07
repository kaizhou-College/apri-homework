package com.kz.entity;

public class Users extends Object{
	
	private int uid;
	private String uname;
	private int uage;
	
	private Dog dog;
	
	public static final String SCHOOL = "Çå»ª";
	
	
	
	
	public Users() {
		super();
	}
	
	
	
	public Users(int uid, String uname, int uage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
	}
	
	





	public Users(int uid, String uname, int uage, Dog dog) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
		this.dog = dog;
	}



	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	
	
	
}
