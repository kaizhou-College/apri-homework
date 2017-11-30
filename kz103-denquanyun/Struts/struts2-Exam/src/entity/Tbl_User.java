package entity;

public class Tbl_User {
	private int uuid;                              
	private String uname;                        
	private String upass;
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
		return "Tbl_User [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	} 
}
