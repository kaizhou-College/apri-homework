package yy.entity;

public class City {
	private int dd;
	private String cname;
	private Integer pid;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "City [dd=" + dd + ", cname=" + cname + ", pid=" + pid + "]";
	}
	public int getDd() {
		return dd;
	}
	public void setDd(int dd) {
		this.dd = dd;
	}
}
