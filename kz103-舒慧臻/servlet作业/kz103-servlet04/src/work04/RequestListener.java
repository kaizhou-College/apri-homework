package work04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestListener implements ServletRequestListener {
	//request������
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request��������");
		ServletRequest servletRequest = sre.getServletRequest();
		long time = (Long)servletRequest.getAttribute("start");
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("start====="+time+"		currentTimeMillis===="+currentTimeMillis);
		long sc = currentTimeMillis-time;
		System.out.println("ʱ��"+sc+"����");
		
		
		
		
	}
	//request�Ĵ���
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request��������");
		long timeMillis = System.currentTimeMillis();
		ServletRequest servletRequest = sre.getServletRequest();
		servletRequest.setAttribute("start",timeMillis);
	}

}
