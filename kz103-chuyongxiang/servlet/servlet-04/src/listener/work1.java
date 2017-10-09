package listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class work1 implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest request = arg0.getServletRequest();
		long hq = (Long) request.getAttribute("abc");
		System.out.println(currentTimeMillis-hq+"秒");
		System.out.println("work1监听器销毁了");
		
	}

	public void requestInitialized(ServletRequestEvent arg1) {
		// TODO Auto-generated method stub
		System.out.println("work1监听器创建了");
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest request = arg1.getServletRequest();
		request.setAttribute("abc", currentTimeMillis);
	}
}
