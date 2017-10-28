package entity;

public class Users {
	private String name;
	private String pwd;
	public Users(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Users [name=" + name + ", pwd=" + pwd + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
