package entity;

public class userself {
	private int uuid;
	private String uname;
	private String upassword;
	
	
	
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String toString() {
		return "userself[uuid="+uuid+",uname="+uname+",upassword="+upassword+"]";
	}
}
