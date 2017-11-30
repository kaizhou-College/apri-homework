package test.entity;

public class Tbl_User {
	private int uuid;//用户ID                                 
	private String uname;//用户名                         
	private String upass;//用户密码
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
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "Tal_User [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	}
	

}
