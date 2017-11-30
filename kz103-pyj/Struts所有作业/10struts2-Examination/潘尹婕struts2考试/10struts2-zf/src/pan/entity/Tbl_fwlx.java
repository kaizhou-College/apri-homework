package pan.entity;
//房屋类型表
public class Tbl_fwlx {
	private int lxid;   //类型id                             
	private String fwlx;//房屋类型
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	@Override
	public String toString() {
		return "tbl_fwlx [fwlx=" + fwlx + ", lxid=" + lxid + "]";
	}
}
