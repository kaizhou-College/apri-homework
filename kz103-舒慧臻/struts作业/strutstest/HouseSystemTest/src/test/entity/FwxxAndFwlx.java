package test.entity;

public class FwxxAndFwlx {
		private int fwid;//房屋ID                                   
		private int uuid;//用户ID                      
		private int jdid;//街道ID                         
		private int lxid;//类型ID                         
		private int shi;//室ID                         
		private int ting;//厅ID                         
		private String fwxx;//房屋信息                        
		private Integer zj;//租金                         
		private String title;//标题                             
		private String publishdate;//发布日期                         
		private String telephone;//联系号码                       
		private String lxr;//类型
		private String fwlx;//房屋类型
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
		
		public String getFwlx() {
			return fwlx;
		}
		public void setFwlx(String fwlx) {
			this.fwlx = fwlx;
		}
		
		@Override
		public String toString() {
			return "Tbl_Fwxx [fwid=" + fwid + ", fwlx=" + fwlx + ", fwxx=" + fwxx
					+ ", jdid=" + jdid + ", lxid=" + lxid + ", lxr=" + lxr
					+ ", publishdate=" + publishdate + ", shi=" + shi
					+ ", telephone=" + telephone + ", ting=" + ting + ", title="
					+ title + ", uuid=" + uuid + ", zj=" + zj + "]";
		}

		


}
