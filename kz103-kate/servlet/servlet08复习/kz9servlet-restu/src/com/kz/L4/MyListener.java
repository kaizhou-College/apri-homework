package com.kz.L4;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener{
	
	
	public MyListener() {
		System.out.println("将听器创建了....");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("监听到session创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("监听到session销毁了");
	}

}
