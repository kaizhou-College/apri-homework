package test.entity;

public class Tbl_Fwlx {
	private int lxid;//类型ID                                 
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
		return "Tal_Fwlx [fwlx=" + fwlx + ", lxid=" + lxid + "]";
	}
	

}
