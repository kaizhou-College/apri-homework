package pan.entity;
//�������ͱ�
public class Tbl_fwlx {
	private int lxid;   //����id                             
	private String fwlx;//��������
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
