package com.kz.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

//����Ϸ�ʽһ��
public class TestAction3 {
	
	private Map<String, Object> requestMap;
	private Map<String, Object> requestParamMap;
	private Map<String, Object> applicationMap;
	private Map<String, Object> sessionMap;
	public String execute(){
		System.out.println("����TestAction3  Ĭ��ִ��execute����");
		//request.Parameter(); ��ȡ�������
		//request.getAttribue(); ��ȡrequest����ֵ
		
		//��ֵ
		ActionContext context = ActionContext.getContext();
		//��ȡ��������ļ��� request.getParameterMap();
		requestParamMap = context.getParameters();
		
		//requestMap.put("r3", "�մ��3");//������
		
		context.put("r33", "�մ��33");//��request�з�ֵ
		
		
		applicationMap = context.getApplication();
		applicationMap.put("a3", "�˴��3");
		
		sessionMap = context.getSession();
		sessionMap.put("s3", "�˴��3");
		//��ֵ
		/*request.setAttribute("r1", "�մ��1");
		session.setAttribute("s1", "�˴��1");
		appliaction.setAttribute("a1", "�˴��1");*/
		
		return "success";
	}
	public String test4(){
		sessionMap.put("s3", "�˴��3");
		return "success";
	}
	
}
