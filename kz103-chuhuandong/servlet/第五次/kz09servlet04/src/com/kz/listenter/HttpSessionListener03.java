package com.kz.listenter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListener03 implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		long currentTimeMillis = System.currentTimeMillis();
		HttpSession request = arg0.getSession();
		long hehe = (Long) request.getAttribute("sss");
		System.out.println(hehe-currentTimeMillis+"∫¡√Îsession");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		long currentTimeMillis = System.currentTimeMillis();
		HttpSession request = arg0.getSession();
		request.setAttribute("sss", currentTimeMillis);
	}
}
