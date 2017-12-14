package yy.entity;

public class District {
	private int did;
	private String dname;
	private Integer cid;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "District [cid=" + cid + ", did=" + did + ", dname=" + dname
				+ "]";
	}
}
