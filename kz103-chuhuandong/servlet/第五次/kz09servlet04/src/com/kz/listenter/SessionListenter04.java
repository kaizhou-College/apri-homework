package com.kz.listenter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenter04 implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sc) {
		ServletContext application = sc.getSession().getServletContext();
		Object object = application.getAttribute("online");
		Object obj = application.getAttribute("sum");
		int online = 0;
		int sum = 0;
		if(object==null){
			online = 0;
			sum = 0;
		}else{
			online = (Integer) object;
			sum = (Integer) obj;
		}
		online++;
		sum++;
		application.setAttribute("online", online);
		application.setAttribute("sum", sum);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent sd) {
		ServletContext application = sd.getSession().getServletContext();
		Object object = application.getAttribute("online");
		int online = 0;
		if(object==null){
			online = 0;
		}else{
			online = (Integer) object;
		}
		if(online >= 0){
			online--;
		}
		application.setAttribute("online", online);
	}
}
