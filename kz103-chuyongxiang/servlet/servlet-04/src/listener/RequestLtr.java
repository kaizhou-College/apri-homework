package listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLtr implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest request = arg0.getServletRequest();
		long hehe = (Long) request.getAttribute("sss");
		System.out.println(currentTimeMillis-hehe+"ʱ��");
		System.out.println("RequestLtr������������");
		
	}

	public void requestInitialized(ServletRequestEvent arg1) {
		// TODO Auto-generated method stub
		System.out.println("RequestLtr������������");
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest request = arg1.getServletRequest();
		request.setAttribute("sss", currentTimeMillis);
	}
}
