package com.kz.entity;

public class ActionForward {
	//(3)׼��һ��ActionForward�Ķ�������װ���ҳ����ַ��������Ƿ���ת�������ض����boolean���͵ı�־��
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
