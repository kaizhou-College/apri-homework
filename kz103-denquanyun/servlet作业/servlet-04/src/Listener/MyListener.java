package Listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*
 * 1.计算一次请求的运行时间：

   写一个RequestLtr类(继承ServletRequestListener),监听Request对象的创建和销毁,在
   requestInitialized方法中得到系统的当前时间，然后设置到ServletRequest对象中，这样就记录了
   请求的开始时间，然后在requestDestroyed方法中同样再得到系统的当前时间，然后ServletRequest对象
   中拿出开始时间，然后算出时间差，打印出来到后台 

 * */

public class MyListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stu
		System.out.println("request被销毁了");
		ServletRequest servletRequest = sre.getServletRequest();
		long time = (Long)servletRequest.getAttribute("start");
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("start====="+time+"		currentTimeMillis===="+currentTimeMillis);
		long sc = currentTimeMillis-time;
		System.out.println("时间差："+sc+"毫秒");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

		System.out.println("request被创建了");
		long timeMillis = System.currentTimeMillis();
		ServletRequest servletRequest = sre.getServletRequest();
		servletRequest.setAttribute("start",timeMillis);

	}

}
