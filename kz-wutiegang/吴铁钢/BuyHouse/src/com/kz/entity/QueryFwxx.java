package com.kz.entity;


public class QueryFwxx extends Tbl_fwxx{

	//���  �۸���һ������
	private String startzj;
	private String endzj;
	//����ʱ��  ���ں���
	private String queryDate;
	
	public String getStartzj() {
		return startzj;
	}
	public void setStartzj(String startzj) {
		this.startzj = startzj;
	}
	public String getEndzj() {
		return endzj;
	}
	public void setEndzj(String endzj) {
		this.endzj = endzj;
	}
	
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	@Override
	public String toString() {
		return "QueryFwxx [endzj=" + endzj + ", queryDate=" + queryDate
				+ ", startzj=" + startzj + "]";
	}
	
	
	
	
}
