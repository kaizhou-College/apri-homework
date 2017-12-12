package com.kz.entity;

public class TBL_JD {
	private int JDID;
	private String JD;
	private int QXID;
	public TBL_JD(int jDID, String jD, int qXID) {
		super();
		JDID = jDID;
		JD = jD;
		QXID = qXID;
	}
	public int getJDID() {
		return JDID;
	}
	public void setJDID(int jDID) {
		JDID = jDID;
	}
	public String getJD() {
		return JD;
	}
	public void setJD(String jD) {
		JD = jD;
	}
	public int getQXID() {
		return QXID;
	}
	public void setQXID(int qXID) {
		QXID = qXID;
	}
	public TBL_JD() {
		super();
	}
	@Override
	public String toString() {
		return "TBL_JD [JD=" + JD + ", JDID=" + JDID + ", QXID=" + QXID + "]";
	}
}
