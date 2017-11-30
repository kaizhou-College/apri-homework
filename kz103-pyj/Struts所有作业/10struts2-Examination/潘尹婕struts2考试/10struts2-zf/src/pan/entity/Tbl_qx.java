package pan.entity;
//房屋区县表
public class Tbl_qx {
	private int qxid;//区县id                               
	private String qx;//房屋区县 
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
		return "tbl_qx [qx=" + qx + ", qxid=" + qxid + "]";
	}
}
