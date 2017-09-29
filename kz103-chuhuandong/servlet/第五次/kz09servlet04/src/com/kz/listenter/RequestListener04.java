package com.kz.listenter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener04 implements ServletRequestListener{
	@Override
	public void requestDestroyed(ServletRequestEvent rd) {
	}
	@Override
	public void requestInitialized(ServletRequestEvent ri) {
		ServletContext appliaction = ri.getServletContext();
		Object obj = appliaction.getAttribute("count");
		int count = 0;
		if(obj==null){
			count = 0;
		}else{
			count = (Integer) obj;
		}
		count++;
		appliaction.setAttribute("count", count);
	}
}
