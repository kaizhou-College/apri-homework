package entity;

public class Users {
	private int userid;                                
	private String username;                          
	private String userpwd;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public Users(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}
	public Users() {
		super();
	}
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username
				+ ", userpwd=" + userpwd + "]";
	}
}
