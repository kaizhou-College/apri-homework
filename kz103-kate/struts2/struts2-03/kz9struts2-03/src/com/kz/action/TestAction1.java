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
//耦合的方式一
public class TestAction1 extends ActionSupport{
	//耦合
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext appliaction;
	
	public String execute(){
		System.out.println("进入TestAction1  默认执行execute方法");
		//传值
		request =ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session =request.getSession();
		
		appliaction = ServletActionContext.getServletContext();
		
		//存值
		request.setAttribute("r1", "苏大姐1");
		session.setAttribute("s1", "邓大姐1");
		appliaction.setAttribute("a1", "潘大姐1");
		return "success";
	}
	public String test(){
		System.out.println("进入TestAction1  执行test方法");
		request.setAttribute("", "");
		return "test_sucsess";
	}
}
