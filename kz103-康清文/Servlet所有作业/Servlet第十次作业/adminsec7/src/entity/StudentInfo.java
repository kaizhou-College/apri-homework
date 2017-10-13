package entity;

import java.io.Serializable;

/**
 * 
 * @author 
 * 写一个简单的实体类，实现序列化的读与写
 */
public class StudentInfo {//implements Serializable{
		
		private int stuid;                              
		private String stunumber;                        
		private String stuname;                       
		private int stuage ;                
		private String stusex ;
		private String stucard  ;                        
		private String stujointime;                             
		private String stuaddress  ;                     
		private int sclassid   ;
	
		public StudentInfo() {
		
		}

		public StudentInfo(int stuid, String stunumber, String stuname,
				int stuage, String stusex, String stucard, String stujointime,
				String stuaddress, int sclassid) {
			super();
			this.stuid = stuid;
			this.stunumber = stunumber;
			this.stuname = stuname;
			this.stuage = stuage;
			this.stusex = stusex;
			this.stucard = stucard;
			this.stujointime = stujointime;
			this.stuaddress = stuaddress;
			this.sclassid = sclassid;
		}

		public int getStuid() {
			return stuid;
		}

		public void setStuid(int stuid) {
			this.stuid = stuid;
		}

		public String getStunumber() {
			return stunumber;
		}

		public void setStunumber(String stunumber) {
			this.stunumber = stunumber;
		}

		public String getStuname() {
			return stuname;
		}

		public void setStuname(String stuname) {
			this.stuname = stuname;
		}

		public int getStuage() {
			return stuage;
		}

		public void setStuage(int stuage) {
			this.stuage = stuage;
		}

		public String getStusex() {
			return stusex;
		}

		public void setStusex(String stusex) {
			this.stusex = stusex;
		}

		public String getStucard() {
			return stucard;
		}

		public void setStucard(String stucard) {
			this.stucard = stucard;
		}

		public String getStujointime() {
			return stujointime;
		}

		public void setStujointime(String stujointime) {
			this.stujointime = stujointime;
		}

		public String getStuaddress() {
			return stuaddress;
		}

		public void setStuaddress(String stuaddress) {
			this.stuaddress = stuaddress;
		}

		public int getSclassid() {
			return sclassid;
		}

		public void setSclassid(int sclassid) {
			this.sclassid = sclassid;
		}

		
		
		public String toString() {
			return "StudentInfo [sclassid=" + sclassid + ", stuaddress="
					+ stuaddress + ", stuage=" + stuage + ", stucard="
					+ stucard + ", stuid=" + stuid + ", stujointime="
					+ stujointime + ", stuname=" + stuname + ", stunumber="
					+ stunumber + ", stusex=" + stusex + "]";
		}
		
		
		
	
	
}
