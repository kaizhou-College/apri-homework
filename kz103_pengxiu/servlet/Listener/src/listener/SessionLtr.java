package listener;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLtr implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("SessionLtr´´½¨");
		long date1 = System.currentTimeMillis();
		se.getSession().setAttribute("date1", date1);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("sessionLtrÏú»Ù");
		long date2 = System.currentTimeMillis();
		int date1 =(Integer) se.getSession().getAttribute("date1");
		se.getSession().setAttribute("date2", date2);
		se.getSession().setAttribute("date3",date2-date1);
		System.out.println(date2-date1);
	}

}
