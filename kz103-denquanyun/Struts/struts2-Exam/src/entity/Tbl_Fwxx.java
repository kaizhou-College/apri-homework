package entity;

public class Tbl_Fwxx {
	private int fwid;                                  
	private Integer uuid;//用户id   
	private Integer qxid;
	private Integer jdid;//街道id                        
	private Integer lxid;//类型id                       
	private Integer shi;     //室                   
	private Integer ting;  //厅                      
	private String fwxx ; //房屋信息            
	private Integer zj;   //租金                     
	private String title;      //标题                    
	private String publishdate;//发布日期                  
	private String telephone;                      
	private String lxr;    //联系人
	public int getFwid() {
		return fwid;
	}
	public void setFwid(int fwid) {
		this.fwid = fwid;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public Integer getJdid() {
		return jdid;
	}
	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}
	public Integer getLxid() {
		return lxid;
	}
	public void setLxid(Integer lxid) {
		this.lxid = lxid;
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
	public String getFwxx() {
		return fwxx;
	}
	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}
	public Integer getZj() {
		return zj;
	}
	public void setZj(Integer zj) {
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
	public Integer getQxid() {
		return qxid;
	}
	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}
	@Override
	public String toString() {
		return "Tbl_Fwxx [fwid=" + fwid + ", fwxx=" + fwxx + ", jdid=" + jdid
				+ ", lxid=" + lxid + ", lxr=" + lxr + ", publishdate="
				+ publishdate + ", qxid=" + qxid + ", shi=" + shi
				+ ", telephone=" + telephone + ", ting=" + ting + ", title="
				+ title + ", uuid=" + uuid + ", zj=" + zj + "]";
	}
}
