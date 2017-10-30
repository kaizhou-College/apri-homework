package com.kz.entity;

public class ActionForward {
	//(3)准备一个ActionForward的对象来封装结果页面的字符串，和是否是转发还是重定向的boolean类型的标志，
	private String uri;
	private boolean isResponse = false;
	public ActionForward(String uri, boolean isResponse) {
		super();
		this.uri = uri;
		this.isResponse = isResponse;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public boolean isResponse() {
		return isResponse;
	}
	public void setResponse(boolean isResponse) {
		this.isResponse = isResponse;
	}
}
