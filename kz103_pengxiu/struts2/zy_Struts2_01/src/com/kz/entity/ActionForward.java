package com.kz.entity;

public class ActionForward {
	private String url;
	private boolean bool;
	public ActionForward(String url, boolean bool) {
		super();
		this.url = url;
		this.bool = bool;
	}
	public ActionForward() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isBool() {
		return bool;
	}
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
}
