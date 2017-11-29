package com.kz.entity;

public class QueryUser extends User{
	//高级查询的一些条件
	private boolean isUpload ;
	private int page = 1;
	private int pageSize = 3;
	private int max;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean getIsUpload() {
		return isUpload;
	}
	public void setIsUpload(int isUpload) {
		this.isUpload = isUpload==1?true:false;
	}
	@Override
	public String toString() {
		return "QueryUser [isUpload=" + isUpload + ", max=" + max + ", page="
				+ page + ", pageSize=" + pageSize +","+super.toString()+ "]";
	}
	
	
	
	
}
