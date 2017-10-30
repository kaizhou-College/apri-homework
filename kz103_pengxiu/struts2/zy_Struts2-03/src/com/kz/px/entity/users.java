package com.kz.px.entity;

public class users {
	private Integer userid;
	private String Username;
	private String Userpwd;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserpwd() {
		return Userpwd;
	}
	public void setUserpwd(String userpwd) {
		Userpwd = userpwd;
	}
	public users(Integer userid, String username, String userpwd) {
		super();
		this.userid = userid;
		Username = username;
		Userpwd = userpwd;
	}
	public users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "users [Username=" + Username + ", Userpwd=" + Userpwd
				+ ", userid=" + userid + "]";
	}
	
}
