package com.kz.examination.entity;

public class Login {
	private String user;
	private String password;
	public Login(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [password=" + password + ", user=" + user + "]";
	}
	
}
