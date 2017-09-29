package com.wtg.Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLtr implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("SessionLtr创建了");
		long timeMillis = System.currentTimeMillis();
		HttpSession session = se.getSession();
		session.setAttribute("timeMillis", timeMillis);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("SessionLtr销毁了");
		
		long millis = System.currentTimeMillis();
		HttpSession session = se.getSession();
		long time = (Long) session.getAttribute("timeMillis");
		System.out.println("时间差："+(millis-time));
	}

}
