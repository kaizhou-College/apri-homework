package com.kz.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
	//application在中----web容内存器重启
	///---application销毁了(将访问量，请求次数保存数据库，文件)
	//---application创建了(读取保存在数据库或者文件中的访问量和请求次数)
	
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}
	//request创建就是请求次数+1
	public void requestInitialized(ServletRequestEvent sre) {
		//1,取出原来的请求次数(在哪里？？？application对象上)
		ServletContext application = sre.getServletContext();
		Object obj=application.getAttribute("count");
		int count = 0;
		if(obj==null){
			count=0;
		}else{
			count = (Integer)obj;
		}
		//2,在原来的请求次数上+1
		count++;
		//3,放到application对象上
		application.setAttribute("count", count);
		
	}

}
