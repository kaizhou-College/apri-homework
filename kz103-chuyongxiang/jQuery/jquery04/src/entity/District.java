package entity;

public class District {
	private int did;
	private String dname;
	private int cid;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "District [cid=" + cid + ", did=" + did + ", dname=" + dname
				+ "]";
	}
	
}
