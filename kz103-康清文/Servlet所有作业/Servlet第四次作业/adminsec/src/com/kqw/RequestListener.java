package com.kqw;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener{
	//����ļ���(�����������)
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletContext application = sre.getServletContext();
		//��application�еõ��������
		Object obj = application.getAttribute("count");
		int count=0;
		if(obj==null){
			count=0;
		}else{
			count=(Integer)obj;
		}
		//��ԭ�������������+1
		count++;
		//����application��
		application.setAttribute("count", count);
	}
	
	

}
