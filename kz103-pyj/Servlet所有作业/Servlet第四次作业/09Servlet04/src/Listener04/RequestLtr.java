package Listener04;
/*   写一个RequestLtr类(继承ServletRequestListener),监听Request对象的创建和销毁,在
   requestInitialized方法中得到系统的当前时间，然后设置到ServletRequest对象中，这样就记录了
   请求的开始时间，然后在requestDestroyed方法中同样再得到系统的当前时间，然后ServletRequest对象
   中拿出开始时间，然后算出时间差，打印出来到后台 
*/
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLtr implements ServletRequestListener{
	public void requestDestroyed(ServletRequestEvent ser) {
		System.out.println("request对象被销毁....");
		ServletRequest servletRequest = ser.getServletRequest();
		long desttime=(Long) servletRequest.getAttribute("inittime");
		long timeMillis = System.currentTimeMillis();//requestDestroyed的系统当前时间
		long cha=timeMillis-desttime;//秒/1000.0
		System.out.println("时间差是："+cha+"毫秒");
	}
	public void requestInitialized(ServletRequestEvent ser) {
		System.out.println("request对象被创建....");
		long time = System.currentTimeMillis();//requestInitialized的系统当前时间
		//System.out.println("init:"+time);
		ServletRequest servletRequest = ser.getServletRequest();
		servletRequest.setAttribute("inittime", time);
	}
}
