package entity;
//写一个省份和城市的二级联动下拉列表
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
	public String toString() {
		return "city [cid=" + cid + ", cname=" + cname + ", pid=" + pid + "]";
	}
}
