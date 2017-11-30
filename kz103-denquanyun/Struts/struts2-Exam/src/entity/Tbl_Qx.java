package entity;

public class Tbl_Qx {//ÆÚÏÞ
	private int qxid;
	private String qx;
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
		return "Tbl_Qx [qx=" + qx + ", qxid=" + qxid + "]";
	}
}
