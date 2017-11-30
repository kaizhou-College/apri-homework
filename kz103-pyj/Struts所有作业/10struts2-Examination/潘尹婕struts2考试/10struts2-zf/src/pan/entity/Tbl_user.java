package pan.entity;
//用户表
public class Tbl_user {
	private int uuid;//用户id                                
	private String uname;//用户姓名                         
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
	public String toString() {
		return "tbl_user [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	}
}
