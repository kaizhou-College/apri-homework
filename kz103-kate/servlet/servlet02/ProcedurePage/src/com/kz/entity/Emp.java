package com.kz.entity;

import java.util.Date;

public class Emp {
	private int empno;
	private String ename;
	private String empjob;
    private String mgr;
    private String hiredate;
    private double sal;
    private double comm;
    private int deptno;
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", comm=" + comm
				+ ", deptno=" + deptno + ", empjob=" + empjob + ", hiredate="
				+ hiredate + ", mgr=" + mgr + ", sal=" + sal + "]";
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmpjob() {
		return empjob;
	}
	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
    
    
}
