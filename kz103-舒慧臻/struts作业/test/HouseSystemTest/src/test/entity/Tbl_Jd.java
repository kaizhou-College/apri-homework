package test.entity;

public class Tbl_Jd {
	private int jdid;//�ֵ�ID                                 
	private String jd;//�ֵ�
	private int qxid;//����ID
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
	@Override
	public String toString() {
		return "Tbl_Jd [jd=" + jd + ", jdid=" + jdid + ", qxid=" + qxid + "]";
	}

}
