package com.kqw;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener{
	//请求的监听(设置请求次数)
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletContext application = sre.getServletContext();
		//从application中得到请求次数
		Object obj = application.getAttribute("count");
		int count=0;
		if(obj==null){
			count=0;
		}else{
			count=(Integer)obj;
		}
		//在原来的请求次数上+1
		count++;
		//放入application中
		application.setAttribute("count", count);
	}
	
	

}
