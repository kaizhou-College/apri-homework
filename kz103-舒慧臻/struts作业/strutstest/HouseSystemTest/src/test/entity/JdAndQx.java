package test.entity;

public class JdAndQx {
	private int jdid;//�ֵ�ID                                 
	private String jd;//�ֵ�
	private int qxid;//����ID
	private String qx;//����
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	
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
		return "JdAndQx [jd=" + jd + ", jdid=" + jdid + ", qx=" + qx
				+ ", qxid=" + qxid + "]";
	}
	

}
