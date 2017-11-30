package test.entity;

public class JdAndQx {
	private int jdid;//街道ID                                 
	private String jd;//街道
	private int qxid;//区县ID
	private String qx;//区县
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
