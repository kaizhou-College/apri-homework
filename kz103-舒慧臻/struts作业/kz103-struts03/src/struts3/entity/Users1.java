package struts3.entity;

public class Users1 {
	private int userid;   //ÓÃ»§±àºÅ                              
	private String username;//µÇÂ¼Ãû³Æ                   
	private String userpwd;//µÇÂ¼ÃÜÂë
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
	@Override
	public String toString() {
		return "Users1 [userid=" + userid + ", username=" + username
				+ ", userpwd=" + userpwd + "]";
	}
	

}
