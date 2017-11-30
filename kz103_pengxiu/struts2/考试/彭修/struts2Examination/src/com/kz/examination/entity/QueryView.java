package com.kz.examination.entity;

public class QueryView {
	public String title;
	public String qu;
	public String jieDao;
	public Integer zhujingStare;
	public Integer zhujingEnd;
	public Integer shi;
	public Integer ting;
	public String houseType;
	public String publishDate;
	
	
	public QueryView(String title, String qu, String jieDao,
			Integer zhujingStare, Integer zhujingEnd, Integer shi,
			Integer ting, String houseType, String publishDate) {
		super();
		this.title = title;
		this.qu = qu;
		this.jieDao = jieDao;
		this.zhujingStare = zhujingStare;
		this.zhujingEnd = zhujingEnd;
		this.shi = shi;
		this.ting = ting;
		this.houseType = houseType;
		this.publishDate = publishDate;
	}
	public QueryView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public Integer getZhujingStare() {
		return zhujingStare;
	}
	public void setZhujingStare(Integer zhujingStare) {
		this.zhujingStare = zhujingStare;
	}
	public Integer getZhujingEnd() {
		return zhujingEnd;
	}
	public void setZhujingEnd(Integer zhujingEnd) {
		this.zhujingEnd = zhujingEnd;
	}
	public Integer getShi() {
		return shi;
	}
	public void setShi(Integer shi) {
		this.shi = shi;
	}
	public Integer getTing() {
		return ting;
	}
	public void setTing(Integer ting) {
		this.ting = ting;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "QueryView [houseType=" + houseType + ", jieDao=" + jieDao
				+ ", publishDate=" + publishDate + ", qu=" + qu + ", shi="
				+ shi + ", ting=" + ting + ", title=" + title + ", zhujingEnd="
				+ zhujingEnd + ", zhujingStare=" + zhujingStare + "]";
	}
	
	
	
	
	
	
}
