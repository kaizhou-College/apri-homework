package entity;

public class Tbl_Jd {
	private int jdid;                           
	private String jd;
	private Integer qxid;
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
	public Integer getQxid() {
		return qxid;
	}
	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}
	@Override
	public String toString() {
		return "Tbl_Jd [jd=" + jd + ", jdid=" + jdid + ", qxid=" + qxid + "]";
	}
}
