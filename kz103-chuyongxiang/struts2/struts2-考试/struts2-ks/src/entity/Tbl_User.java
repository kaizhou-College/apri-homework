package entity;

public class Tbl_User {
	private int uuid;		//�û�id
	private String uname;	//�û���
	private String upass;	//�û�����
	public Tbl_User(int uuid, String uname, String upass) {
		super();
		this.uuid = uuid;
		this.uname = uname;
		this.upass = upass;
	}
	public Tbl_User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tbl_User [uname=" + uname + ", upass=" + upass + ", uuid="
				+ uuid + "]";
	}
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
	
}
