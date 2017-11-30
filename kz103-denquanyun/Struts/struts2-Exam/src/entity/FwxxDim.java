package entity;

public class FwxxDim {
	private String title;
	private Integer qxid;
	private Integer jdid;
	private Integer startzj;
	private Integer endzj;
	private Integer shi;
	private Integer ting;
	private Integer lxid;
	private Integer time;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getQxid() {
		return qxid;
	}
	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}
	public Integer getJdid() {
		return jdid;
	}
	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}
	public Integer getStartzj() {
		return startzj;
	}
	public void setStartzj(Integer startzj) {
		this.startzj = startzj;
	}
	public Integer getEndzj() {
		return endzj;
	}
	public void setEndzj(Integer endzj) {
		this.endzj = endzj;
	}
	public Integer getShi() {
		return shi;
	}
	public void setShi(Integer shi) {
		this.shi = shi;
	}
	public Integer getTing() {
		return ting;
	}
	public void setTing(Integer ting) {
		this.ting = ting;
	}
	public Integer getLxid() {
		return lxid;
	}
	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "FwxxDim [endzj=" + endzj + ", jdid=" + jdid + ", lxid=" + lxid
				+ ", qxid=" + qxid + ", shi=" + shi + ", startzj=" + startzj
				+ ", time=" + time + ", ting=" + ting + ", title=" + title
				+ "]";
	}
}
