package com.wtg.Listener;



import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLtr implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("RequestLtr被销毁了");

		long timeMillis = System.currentTimeMillis();
		
		//System.out.println("dataTime==="+dataTime);
		
		ServletRequest request = sre.getServletRequest();
		long time=(Long)request.getAttribute("time");
		//System.out.println("dataTime==="+dataTime);
		double ptime=(timeMillis-time)/1000.0;
		
		System.out.println("ztime==="+ptime);
	}

	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("RequestLtr被创建了");
		long timeMillis = System.currentTimeMillis();
		System.out.println("timeMillis===="+timeMillis);
		ServletRequest request = sre.getServletRequest();
		request.setAttribute("time",timeMillis);
	}

}
