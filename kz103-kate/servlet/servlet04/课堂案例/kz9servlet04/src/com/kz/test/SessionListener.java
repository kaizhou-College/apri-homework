package com.kz.test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	//在线人数+1    访问次数+1
	public void sessionCreated(HttpSessionEvent se) {
		//1,获取原来的在线人数和访问次数(人数在哪里？application)
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
		//2,在原来的在线人数和访问次数上+1
		onLine++;
		all++;
		
		//3,保存新的在线人数和访问次数
		application.setAttribute("onLine", onLine);
		application.setAttribute("all", all);
		
	}
	////在线人数-1
	public void sessionDestroyed(HttpSessionEvent se) {
		//1,获取原来的在线人数
		ServletContext application = se.getSession().getServletContext();
		Object obj = application.getAttribute("onLine");
		int onLine = 0;
		if(obj==null){
			onLine = 0;
		}else{
			onLine = (Integer) obj;
			//2,在原来的在线人数上-1
			onLine--;
		}
		//3,保存新的在线人数
		application.setAttribute("onLine", onLine);
	}

}
