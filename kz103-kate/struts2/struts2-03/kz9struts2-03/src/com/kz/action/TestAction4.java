package com.kz.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

//解耦合方式二：
public class TestAction4 implements RequestAware,SessionAware,ApplicationAware{
	private Map<String, Object> request;
	private Map<String, Object> requestParamMap;
	private Map<String, Object> applicationMap;
	private Map<String, Object> sessionMap;
	public String execute(){
		System.out.println("进入TestAction3  默认执行execute方法");
		
		//传值
		request.put("r4","苏大姐4");
		applicationMap.put("a4", "潘大姐4");
		sessionMap.put("s4", "邓大姐4");
		//存值
		return "success";
	}
	public String test4(){
		request.put("r4","苏大姐4");
		applicationMap.put("a4", "潘大姐4");
		sessionMap.put("s4", "邓大姐4");
		return "success";
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.sessionMap =session;
	}
	public void setApplication(Map<String, Object> application) {
		this.applicationMap = application;
	}
	
}
