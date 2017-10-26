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

//��ϵķ�ʽ��
public class TestAction2 implements ServletRequestAware,SessionAware,ServletContextAware{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext appliaction;
	
	public String test2(){
		System.out.println("����TestAction1  Ĭ��ִ��execute����");
		//��ֵ
		request =ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session =request.getSession();
		appliaction = ServletActionContext.getServletContext();
		
		//��ֵ
		request.setAttribute("r2", "�մ��2");
		session.setAttribute("s2", "�˴��2");
		appliaction.setAttribute("a2", "�˴��2");
		
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
