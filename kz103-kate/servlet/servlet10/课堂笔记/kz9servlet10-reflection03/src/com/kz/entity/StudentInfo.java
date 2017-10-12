package com.kz.entity;

import java.io.Serializable;

public class StudentInfo implements Serializable{
	private int stuid;                              
	private String stunumber;                        
	private String stuname;                       
	private int stuage ;                
	private String stusex ;
	private String stucard  ;                        
	private String stujointime;                             
	private String stuaddress  ;                     
	private int sclassid   ;
	
	//静态属性和瞬时属性不会被序列化
	private static int a;
	private transient int b;
	
	public static int getA() {
		return a;
	}
	public static void setA(int a) {
		StudentInfo.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	@Override
	public String toString() {
		return "StudentInfo [b=" + b + ", sclassid=" + sclassid
				+ ", stuaddress=" + stuaddress + ", stuage=" + stuage
				+ ", stucard=" + stucard + ", stuid=" + stuid
				+ ", stujointime=" + stujointime + ", stuname=" + stuname
				+ ", stunumber=" + stunumber + ", stusex=" + stusex + "]";
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
	
}
