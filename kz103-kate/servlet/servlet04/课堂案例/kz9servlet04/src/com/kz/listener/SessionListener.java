package com.kz.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//session����
public class SessionListener implements HttpSessionListener{
	public SessionListener(){
		System.out.println("SessionListener������");
	}
	//����session�Ĵ���
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session������...");
	
	}
	//����session������
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session������....");
		
	}
	
}
