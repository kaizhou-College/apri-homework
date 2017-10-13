package entity;

import java.io.Serializable;

public class USERS implements Cloneable,Serializable{
	private int id;
	private String name;
	private String pwd;
//	private JOB zhiwei;
	public USERS(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "USERS [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	public USERS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public JOB getZhiwei() {
//		return zhiwei;
//	}
//	public void setZhiwei(JOB zhiwei) {
//		this.zhiwei = zhiwei;
//	}
//	
//	
//	public Object clone() throws CloneNotSupportedException{
//		USERS u=(USERS)super.clone();
//		JOB job2=(JOB) this.zhiwei.clone();
//		u.setZhiwei(job2);
//		return u;
//		
//	}
	
}
