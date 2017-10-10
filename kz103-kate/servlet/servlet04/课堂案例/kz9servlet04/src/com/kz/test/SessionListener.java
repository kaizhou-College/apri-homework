package com.kz.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	//��������+1    ���ʴ���+1
	public void sessionCreated(HttpSessionEvent se) {
		//1,��ȡԭ�������������ͷ��ʴ���(���������application)
		ServletContext application = se.getSession().getServletContext();
		Object obj = application.getAttribute("onLine");
		int onLine = 0;
		if(obj==null){
			onLine = 0;
		}else{
			onLine = (Integer) obj;
		}
		
		obj = application.getAttribute("all");
		int all = 0;
		if(obj==null){
			all = 0;
		}else{
			all = (Integer) obj;
		}
		//2,��ԭ�������������ͷ��ʴ�����+1
		onLine++;
		all++;
		
		//3,�����µ����������ͷ��ʴ���
		application.setAttribute("onLine", onLine);
		application.setAttribute("all", all);
		
	}
	////��������-1
	public void sessionDestroyed(HttpSessionEvent se) {
		//1,��ȡԭ������������
		ServletContext application = se.getSession().getServletContext();
		Object obj = application.getAttribute("onLine");
		int onLine = 0;
		if(obj==null){
			onLine = 0;
		}else{
			onLine = (Integer) obj;
			//2,��ԭ��������������-1
			onLine--;
		}
		//3,�����µ���������
		application.setAttribute("onLine", onLine);
	}

}
