package com.wtg.entity;

public class AuctionUser {
	private Integer userid;
	private String username;
	private String userpassword;
	private String usercardno;
	private String usertel;
	private String useraddress;
	private String userpostnumber;
	private Integer userisadmin;
	private String userquestion;
	private String useranswer;
	
	public AuctionUser(Integer userisadmin) {
		super();
		this.userisadmin = userisadmin;
	}
	public AuctionUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public String getUsercardno() {
		return usercardno;
	}
	public String getUsertel() {
		return usertel;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public String getUserpostnumber() {
		return userpostnumber;
	}
	public Integer getUserisadmin() {
		return userisadmin;
	}
	public String getUserquestion() {
		return userquestion;
	}
	public String getUseranswer() {
		return useranswer;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public void setUsercardno(String usercardno) {
		this.usercardno = usercardno;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public void setUserpostnumber(String userpostnumber) {
		this.userpostnumber = userpostnumber;
	}
	public void setUserisadmin(Integer userisadmin) {
		this.userisadmin = userisadmin;
	}
	public void setUserquestion(String userquestion) {
		this.userquestion = userquestion;
	}
	public void setUseranswer(String useranswer) {
		this.useranswer = useranswer;
	}
	@Override
	public String toString() {
		return "AuctionUser [useraddress=" + useraddress + ", useranswer="
				+ useranswer + ", usercardno=" + usercardno + ", userid="
				+ userid + ", userisadmin=" + userisadmin + ", username="
				+ username + ", userpassword=" + userpassword
				+ ", userpostnumber=" + userpostnumber + ", userquestion="
				+ userquestion + ", usertel=" + usertel + "]";
	}
	
}
