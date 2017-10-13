package com.kz.entity;

public class TeacherInfo {
	 private int teacherid;
	 private String teachername;
	 private String teachertel;
	 private String teacheremail;
	public TeacherInfo() {
		super();
	}
	public TeacherInfo(int teacherid, String teachername, String teachertel,
			String teacheremail) {
		super();
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.teachertel = teachertel;
		this.teacheremail = teacheremail;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getTeachertel() {
		return teachertel;
	}
	public void setTeachertel(String teachertel) {
		this.teachertel = teachertel;
	}
	public String getTeacheremail() {
		return teacheremail;
	}
	public void setTeacheremail(String teacheremail) {
		this.teacheremail = teacheremail;
	}
	@Override
	public String toString() {
		return "Teacher [teacheremail=" + teacheremail + ", teacherid="
				+ teacherid + ", teachername=" + teachername + ", teachertel="
				+ teachertel + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
