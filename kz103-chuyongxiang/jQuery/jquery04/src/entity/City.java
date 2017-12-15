package entity;

public class City {
	private int cid;
	private String cname;
	private int pid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "city [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}
	
}
