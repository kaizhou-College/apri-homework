package com.kz.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
	//application����----web���ڴ�������
	///---application������(������������������������ݿ⣬�ļ�)
	//---application������(��ȡ���������ݿ�����ļ��еķ��������������)
	
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}
	//request���������������+1
	public void requestInitialized(ServletRequestEvent sre) {
		//1,ȡ��ԭ�����������(���������application������)
		ServletContext application = sre.getServletContext();
		Object obj=application.getAttribute("count");
		int count = 0;
		if(obj==null){
			count=0;
		}else{
			count = (Integer)obj;
		}
		//2,��ԭ�������������+1
		count++;
		//3,�ŵ�application������
		application.setAttribute("count", count);
		
	}

}
