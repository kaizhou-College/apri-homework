package com.kz.L4;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener{
	
	
	public MyListener() {
		System.out.println("������������....");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("������session������");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("������session������");
	}

}
