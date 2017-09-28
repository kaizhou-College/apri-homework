package com.wtg.Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLtr implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("SessionLtr������");
		long timeMillis = System.currentTimeMillis();
		HttpSession session = se.getSession();
		session.setAttribute("timeMillis", timeMillis);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("SessionLtr������");
		
		long millis = System.currentTimeMillis();
		HttpSession session = se.getSession();
		long time = (Long) session.getAttribute("timeMillis");
		System.out.println("ʱ��"+(millis-time));
	}

}
