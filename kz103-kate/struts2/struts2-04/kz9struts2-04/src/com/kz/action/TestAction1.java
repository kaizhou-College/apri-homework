package com.kz.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//action���������򣺱���Action (��������ĸ��д)
public class TestAction1 extends ActionSupport{
	private String name;//root
	private HttpServletRequest request;
	public String test(){
		name ="������";
		request = ServletActionContext.getRequest();
		request.setAttribute("sname", "��ͷǿ");//��root
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
