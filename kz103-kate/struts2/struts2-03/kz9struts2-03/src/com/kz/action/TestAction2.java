package com.kz.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

//耦合的方式二
public class TestAction2 implements ServletRequestAware,SessionAware,ServletContextAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext appliaction;
	
	public String test2(){
		System.out.println("进入TestAction1  默认执行execute方法");
		//传值
		request =ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session =request.getSession();
		appliaction = ServletActionContext.getServletContext();
		
		//存值
		request.setAttribute("r2", "苏大姐2");
		session.setAttribute("s2", "邓大姐2");
		appliaction.setAttribute("a2", "潘大姐2");
		
		return "success";
	}
	
	
	public void setServletRequest(HttpServletRequest request) {
		this.request =request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = request.getSession();
	}
	public void setServletContext(ServletContext context) {
		this.appliaction = context;
	}

}
