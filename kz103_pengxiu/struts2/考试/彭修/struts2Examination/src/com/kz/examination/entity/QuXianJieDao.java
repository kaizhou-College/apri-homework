package com.kz.examination.entity;

public class QuXianJieDao {
	private String qu;
	private String jieDao;
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getJieDao() {
		return jieDao;
	}
	public void setJieDao(String jieDao) {
		this.jieDao = jieDao;
	}
	@Override
	public String toString() {
		return "QuXianJieDao [jieDao=" + jieDao + ", qu=" + qu + "]";
	}
	
}
