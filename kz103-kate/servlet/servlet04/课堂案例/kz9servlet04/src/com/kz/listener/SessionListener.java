package com.kz.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//session监听
public class SessionListener implements HttpSessionListener{
	public SessionListener(){
		System.out.println("SessionListener创建了");
	}
	//监听session的创建
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session创建了...");
	
	}
	//监听session的销毁
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁了....");
		
	}
	
}
