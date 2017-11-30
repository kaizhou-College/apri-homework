package com.kz.entity;


public class QueryFwxx extends Tbl_fwxx{

	//租金  价格是一个区间
	private String startzj;
	private String endzj;
	//发布时间  日期函数
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
