package com.wtg.Action;

public class ActionForward {
	private String url;//���ҳ����ַ���
	private boolean isRedirect=true;//trueΪ�ض���
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public ActionForward(String url, boolean isRedirect) {
		super();
		this.url = url;
		this.isRedirect = isRedirect;
	}
	
}
