package test.entity;

public class Tbl_Qx {
	private int qxid;//房屋区县id                                 
	private String qx;//区县
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}
	@Override
	public String toString() {
		return "Tal_Qx [qx=" + qx + ", qxid=" + qxid + "]";
	}
	

}
