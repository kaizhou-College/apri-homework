package com.kqw;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	//请求的次数和在线人数
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		Object obj = application.getAttribute("onLine");
		int onLine=0;
		if(obj==null){
			onLine=0;
		}else{
			onLine=(Integer)obj;
		}
		onLine++;
		application.setAttribute("onLine", onLine);
		obj = application.getAttribute("all");
		int all=0;
		if(obj==null){
			all=0;
		}else{
			all=(Integer)obj;
		}
		all++;
		application.setAttribute("all", all);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		Object obj = application.getAttribute("onLine");
		int onLine=0;
		if(obj==null){
			onLine=0;			
		}else{
			onLine=(Integer)obj;
		}
		onLine--;
		application.setAttribute("onLine", onLine);
	}

}
