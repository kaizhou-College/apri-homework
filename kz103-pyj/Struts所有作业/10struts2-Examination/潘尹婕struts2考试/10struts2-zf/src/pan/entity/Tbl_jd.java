package pan.entity;
//�ֵ���
public class Tbl_jd {
	private int jdid;//�ֵ�id                                 
	private String jd;//�ֵ���  
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
	@Override
	public String toString() {
		return "tbl_jd [jd=" + jd + ", jdid=" + jdid + "]";
	}
}
