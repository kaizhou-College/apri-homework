package pan.entity;
//�������ر�
public class Tbl_qx {
	private int qxid;//����id                               
	private String qx;//�������� 
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
