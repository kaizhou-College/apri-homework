package struts1.entity;

public class Users {
	private String uname;
	private String password;
	private String birthday;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(String uname, String password, String birthday) {
		super();
		this.uname = uname;
		this.password = password;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [birthday=" + birthday + ", password=" + password
				+ ", uname=" + uname + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
