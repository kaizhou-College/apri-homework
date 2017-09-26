package com.kz.listenter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListenter01 implements ServletRequestListener{
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest request = arg0.getServletRequest();
		long hehe = (Long) request.getAttribute("sss");
		System.out.println(currentTimeMillis-hehe+"∫¡√Î");
	}
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest request = arg0.getServletRequest();
		request.setAttribute("sss", currentTimeMillis);
	}
}
