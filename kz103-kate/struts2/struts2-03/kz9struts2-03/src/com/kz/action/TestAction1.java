package com.kz.action;

import javax.jms.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpHeaderResult;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//��ϵķ�ʽһ
public class TestAction1 extends ActionSupport{
	//���
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext appliaction;
	
	public String execute(){
		System.out.println("����TestAction1  Ĭ��ִ��execute����");
		//��ֵ
		request =ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session =request.getSession();
		
		appliaction = ServletActionContext.getServletContext();
		
		//��ֵ
		request.setAttribute("r1", "�մ��1");
		session.setAttribute("s1", "�˴��1");
		appliaction.setAttribute("a1", "�˴��1");
		return "success";
	}
	public String test(){
		System.out.println("����TestAction1  ִ��test����");
		request.setAttribute("", "");
		return "test_sucsess";
	}
}
