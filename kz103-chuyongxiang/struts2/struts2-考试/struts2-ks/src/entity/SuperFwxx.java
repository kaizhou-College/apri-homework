package entity;

public class SuperFwxx {
	private int fwid;				//房屋id
	private int uuid;				//用户id
	private int jdid;				//街道id
	private int lxid;				//类型id
	private int shi;				//室
	private int ting;				//厅
	private String fwxx;			//房屋信息
	private int zj;					//资金
	private String title;			//标题
	private String publishdate;		//发布时间
	private String telephone;		//联系电话
	private String lxr;				//联系人
	private int qxid;				//区县id
	private int zj1;				//第二个资金
	private String fabudate;		//发布的相隔时间
	private String mohu;
	public int getFwid() {
		return fwid;
	}
	public void setFwid(int fwid) {
		this.fwid = fwid;
	}
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public int getJdid() {
		return jdid;
	}
	public void setJdid(int jdid) {
		this.jdid = jdid;
	}
	public int getLxid() {
		return lxid;
	}
	public void setLxid(int lxid) {
		this.lxid = lxid;
	}
	public int getShi() {
		return shi;
	}
	public void setShi(int shi) {
		this.shi = shi;
	}
	public int getTing() {
		return ting;
	}
	public void setTing(int ting) {
		this.ting = ting;
	}
	public String getFwxx() {
		return fwxx;
	}
	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}
	public int getZj() {
		return zj;
	}
	public void setZj(int zj) {
		this.zj = zj;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	public int getZj1() {
		return zj1;
	}
	public void setZj1(int zj1) {
		this.zj1 = zj1;
	}
	public String getFabudate() {
		return fabudate;
	}
	public void setFabudate(String fabudate) {
		this.fabudate = fabudate;
	}
	public String getMohu() {
		return mohu;
	}
	public void setMohu(String mohu) {
		this.mohu = mohu;
	}
	@Override
	public String toString() {
		return "SuperFwxx [fabudate=" + fabudate + ", fwid=" + fwid
				+ ", fwxx=" + fwxx + ", jdid=" + jdid + ", lxid=" + lxid
				+ ", lxr=" + lxr + ", mohu=" + mohu + ", publishdate="
				+ publishdate + ", qxid=" + qxid + ", shi=" + shi
				+ ", telephone=" + telephone + ", ting=" + ting + ", title="
				+ title + ", uuid=" + uuid + ", zj=" + zj + ", zj1=" + zj1
				+ "]";
	}
	

	
}
