package entity;

public class Tbl_Fwxx {
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
	public Tbl_Fwxx(int fwid, int uuid, int jdid, int lxid, int shi, int ting,
			String fwxx, int zj, String title, String publishdate,
			String telephone, String lxr) {
		super();
		this.fwid = fwid;
		this.uuid = uuid;
		this.jdid = jdid;
		this.lxid = lxid;
		this.shi = shi;
		this.ting = ting;
		this.fwxx = fwxx;
		this.zj = zj;
		this.title = title;
		this.publishdate = publishdate;
		this.telephone = telephone;
		this.lxr = lxr;
	}
	@Override
	public String toString() {
		return "Tbl_Fwxx [fwid=" + fwid + ", fwxx=" + fwxx + ", jdid=" + jdid
				+ ", lxid=" + lxid + ", lxr=" + lxr + ", publishdate="
				+ publishdate + ", shi=" + shi + ", telephone=" + telephone
				+ ", ting=" + ting + ", title=" + title + ", uuid=" + uuid
				+ ", zj=" + zj + "]";
	}
	public Tbl_Fwxx() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
