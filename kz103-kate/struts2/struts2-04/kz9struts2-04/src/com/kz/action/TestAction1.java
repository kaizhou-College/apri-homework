package com.kz.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//action的命名规则：表名Action (表名首字母大写)
public class TestAction1 extends ActionSupport{
	private String name;//root
	private HttpServletRequest request;
	public String test(){
		name ="二狗子";
		request = ServletActionContext.getRequest();
		request.setAttribute("sname", "光头强");//非root
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
