package test.entity;

public class FwxxAndFwlx {
		private int fwid;//����ID                                   
		private int uuid;//�û�ID                      
		private int jdid;//�ֵ�ID                         
		private int lxid;//����ID                         
		private int shi;//��ID                         
		private int ting;//��ID                         
		private String fwxx;//������Ϣ                        
		private Integer zj;//���                         
		private String title;//����                             
		private String publishdate;//��������                         
		private String telephone;//��ϵ����                       
		private String lxr;//����
		private String fwlx;//��������
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
