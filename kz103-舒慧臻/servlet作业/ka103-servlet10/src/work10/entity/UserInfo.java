package work10.entity;

public class UserInfo extends Object implements Cloneable {
	private int customerid;              
	private String createtime;         
	private String email;             
	private int language; 
	private String username;             
	private String screenname;                 
	private String password;         
	private int ismale;
	private String birthday;                  
	private String postalcode;              
	private String firstname;             
	private String lastname;             
	private String address;
	//private Dept dp;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
//	public Dept getDp() {
//		return dp;
//	}
//	public void setDp(Dept dp) {
//		this.dp = dp;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getLanguage() {
		return language;
	}
	public void setLanguage(int language) {
		this.language = language;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getScreenname() {
		return screenname;
	}
	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsmale() {
		return ismale;
	}
	public void setIsmale(int ismale) {
		this.ismale = ismale;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInfo [address=" + address + ", birthday=" + birthday
				+ ", createtime=" + createtime + ", customerid=" + customerid
				+ ", email=" + email + ", firstname=" + firstname + ", ismale="
				+ ismale + ", language=" + language + ", lastname=" + lastname
				+ ", password=" + password + ", postalcode=" + postalcode
				+ ", screenname=" + screenname + ", username=" + username + "]";
	}
	
/*	public Object clone() throws CloneNotSupportedException{
			UserInfo u = (UserInfo) super.clone();
			Dept d = (Dept) this.dp.clone();
			//將克隆Dept的對象複製給克隆的UserInfo
			u.setDp(d);
			return u;
		
	}*/
	
	

}
