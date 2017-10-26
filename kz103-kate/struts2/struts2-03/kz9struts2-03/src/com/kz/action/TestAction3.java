package com.kz.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

//解耦合方式一：
public class TestAction3 {
	
	private Map<String, Object> requestMap;
	private Map<String, Object> requestParamMap;
	private Map<String, Object> applicationMap;
	private Map<String, Object> sessionMap;
	public String execute(){
		System.out.println("进入TestAction3  默认执行execute方法");
		//request.Parameter(); 获取请求参数
		//request.getAttribue(); 获取request域中值
		
		//传值
		ActionContext context = ActionContext.getContext();
		//获取请求参数的集合 request.getParameterMap();
		requestParamMap = context.getParameters();
		
		//requestMap.put("r3", "苏大姐3");//带参数
		
		context.put("r33", "苏大姐33");//往request中放值
		
		
		applicationMap = context.getApplication();
		applicationMap.put("a3", "潘大姐3");
		
		sessionMap = context.getSession();
		sessionMap.put("s3", "邓大姐3");
		//存值
		/*request.setAttribute("r1", "苏大姐1");
		session.setAttribute("s1", "邓大姐1");
		appliaction.setAttribute("a1", "潘大姐1");*/
		
		return "success";
	}
	public String test4(){
		sessionMap.put("s3", "邓大姐3");
		return "success";
	}
	
}
