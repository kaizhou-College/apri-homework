package entity;

public class ClassInfo {
	private int classid;                                 
	private String classnumber;  
	private int cteacherid;
	private String classgrade;
	public ClassInfo() {
		super();
	}
	public ClassInfo(int classid, String classnumber, int cleacherid,String classgrade) {
		super();
		this.classid = classid;
		this.classnumber = classnumber;
		this.cteacherid = cteacherid;
		this.classgrade = classgrade;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(String classnumber) {
		this.classnumber = classnumber;
	}
	public int getCteacherid() {
		return cteacherid;
	}
	public void setCteacherid(int cteacherid) {
		this.cteacherid = cteacherid;
	}
	
	public String getClassgrade() {
		return classgrade;
	}
	public void setClassgrade(String classgrade) {
		this.classgrade = classgrade;
	}
	public String toString() {
		return "ClassInfo [classgrade=" + classgrade + ", classid=" + classid
				+ ", classnumber=" + classnumber + ", cteacherid=" + cteacherid
				+ "]";
	}
}
