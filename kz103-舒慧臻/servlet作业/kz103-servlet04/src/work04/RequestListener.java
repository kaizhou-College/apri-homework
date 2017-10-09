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
	//request的销毁
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request被销毁了");
		ServletRequest servletRequest = sre.getServletRequest();
		long time = (Long)servletRequest.getAttribute("start");
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("start====="+time+"		currentTimeMillis===="+currentTimeMillis);
		long sc = currentTimeMillis-time;
		System.out.println("时间差："+sc+"毫秒");
		
		
		
		
	}
	//request的创建
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request被创建了");
		long timeMillis = System.currentTimeMillis();
		ServletRequest servletRequest = sre.getServletRequest();
		servletRequest.setAttribute("start",timeMillis);
	}

}
