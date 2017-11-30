package pan.entity;
public class FwxxView extends Tbl_fwxx{
		private String title;
		private String telephone;
		private String lxr;
		private String fwlx;
		private Integer shi;
		private Integer ting;
		private Integer zj;
		private String jd;
		private String time;
		private String fwxx;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
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
		public Integer getZj() {
			return zj;
		}
		public void setZj(Integer zj) {
			this.zj = zj;
		}
		public String getJd() {
			return jd;
		}
		public void setJd(String jd) {
			this.jd = jd;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getFwxx() {
			return fwxx;
		}
		public void setFwxx(String fwxx) {
			this.fwxx = fwxx;
		}
		public String toString() {
			return "FwxxView [fwlx=" + fwlx + ", fwxx=" + fwxx + ", jd=" + jd
					+ ", lxr=" + lxr + "," +" shi=" + shi
					+ ", telephone=" + telephone + ", time=" + time + ", ting="
					+ ting + ", title=" + title + ", zj=" + zj + "]";
		}
}
