package entity;

public class ClassInfo {
	private int classid;                                 
	private String classnumber;            
	private String classgrade;
	public ClassInfo() {
		super();
	}
	public ClassInfo(int classid, String classnumber, String classgrade) {
		super();
		this.classid = classid;
		this.classnumber = classnumber;
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
	public String getClassgrade() {
		return classgrade;
	}
	public void setClassgrade(String classgrade) {
		this.classgrade = classgrade;
	}
	public String toString() {
		return "ClassInfo [classgrade=" + classgrade + ", classid=" + classid
				+ ", classnumber=" + classnumber + "]";
	}
}
