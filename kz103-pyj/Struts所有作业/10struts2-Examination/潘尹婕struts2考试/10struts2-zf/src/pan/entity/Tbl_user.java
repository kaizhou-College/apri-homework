package pan.entity;
//�û���
public class Tbl_user {
	private int uuid;//�û�id                                
	private String uname;//�û�����                         
	private String upass;//�û�����
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
